package br.senai.sp.fitware.api

import br.senai.sp.fitware.model.UserLoginModel
import retrofit2.Call
import retrofit2.http.POST

interface LoginCall {

    @POST("sessions")
    fun getSession() : Call<List<UserLoginModel>>
}