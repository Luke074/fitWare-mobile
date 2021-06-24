package br.senai.sp.fitware.api.rotas

import br.senai.sp.fitware.model.Schedules
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface AulasDisponiveisCall {

    @GET("schedule")
    fun getAulas(@Header("Authorization") token: String?) : Call<List<Schedules>>

}