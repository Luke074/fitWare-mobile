package br.senai.sp.fitware.api.rotas

import br.senai.sp.fitware.model.UserRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterCall {

    @POST("userAcademy")
    fun register(@Body register: UserRegister): Call<UserRegister>
}