package br.senai.sp.fitware.api.rotas

import br.senai.sp.fitware.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface UserCall {

    @GET("userAcademy/{id}")
    fun getUser(@Path("id") id: Int, @Header("Authorization") token: String?) : Call<User>
}