package br.senai.sp.fitware.api.rotas

import br.senai.sp.fitware.model.Token
import br.senai.sp.fitware.model.UserLoginModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginCall {

    @POST("sessions")
    fun singIn(@Body user: UserLoginModel): Call<Token>
}