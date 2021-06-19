package br.senai.sp.fitware.api.rotas

import br.senai.sp.fitware.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserCall {

    @GET("schedule")
    fun getUser() : Call<List<User>>
}