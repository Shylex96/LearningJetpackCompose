package com.example.jetpackcomposemvvmlivedata.login.data.network

class LoginRepository {
    private val api = LoginService()

    suspend fun doLogin(user:String, password:String): Boolean {
        return api.doLogin(user, password)
    }

}