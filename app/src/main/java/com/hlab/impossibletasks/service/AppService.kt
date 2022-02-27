package com.hlab.impossibletasks.service

import android.util.Log
import com.google.gson.Gson
import com.hlab.impossibletasks.data.model.LogInRequestModel
import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException


class AppService {

    val TAG = "AppService"

    val okhttpClient = OkHttpClient()

    fun login(logInRequest: LogInRequestModel) {
        val postUrl = "https://aj9te3smvj.execute-api.us-east-1.amazonaws.com/dev/signin"
        val body: RequestBody = Gson().toJson(logInRequest.toString()).toRequestBody()

        val request: Request = Request.Builder()
            .url(postUrl)
            .post(body)
            .build()

        okhttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(TAG, e.localizedMessage)
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d(TAG, response.body.toString())
            }

        })
    }
}