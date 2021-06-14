package br.senai.sp.fitware.api

import br.senai.sp.fitware.model.AulaOnline
import retrofit2.Call
import retrofit2.http.GET

interface AulasAgendadasCall {

    @GET("schedule")
    fun getAulasAgendadas() : Call<List<AulaOnline>>
}