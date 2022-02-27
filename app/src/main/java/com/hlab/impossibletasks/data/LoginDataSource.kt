package com.hlab.impossibletasks.data

import com.hlab.impossibletasks.data.model.LogInRequestModel
import com.hlab.impossibletasks.data.model.LoggedInUser
import com.hlab.impossibletasks.service.ServiceHandler
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        ServiceHandler.login(LogInRequestModel(username, password))
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}