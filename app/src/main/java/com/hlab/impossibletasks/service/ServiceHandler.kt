package com.hlab.impossibletasks.service

import com.hlab.impossibletasks.data.model.LogInRequestModel

class ServiceHandler {
    companion object {
        private var mService: AppService = AppService()
        private var serviceHandler: ServiceHandler? = null
        fun getInstance(): ServiceHandler {
            return if (serviceHandler == null) {
                ServiceHandler()
            } else {
                serviceHandler!!
            }
        }

        fun login(loginRequest: LogInRequestModel) {
            mService.login(loginRequest)
        }
    }
}