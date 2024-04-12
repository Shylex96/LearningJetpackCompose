package com.example.jetpackcomposemvvmlivedata.login.domain

import com.example.jetpackcomposemvvmlivedata.login.data.network.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user:String, password:String):Boolean{
        return repository.doLogin(user, password)
    }
}