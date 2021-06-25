package br.senai.sp.fitware.api.rotas

import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface IncludeStudent {

    @POST("schedule/{id}/student")
    fun includeAula(@Path("id") id: Int, @Header("Authorization") token: String?)
}