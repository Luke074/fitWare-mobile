package br.senai.sp.fitware.api.rotas

import br.senai.sp.fitware.model.StudentSchedules
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface IncludeStudent {

    @POST("schedule/{id}/student")
    fun includeAula(@Path("id") id: Long, @Header("Authorization") token: String?) : Call<StudentSchedules>

    @GET("schedule/{id}/student")
    fun listAula(@Path("id") id: Long, @Header("Authorization") token: String?) : Call<List<StudentSchedules>>
}