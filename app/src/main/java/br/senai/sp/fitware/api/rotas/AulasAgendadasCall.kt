package br.senai.sp.fitware.api.rotas

import br.senai.sp.fitware.model.Schedules
import retrofit2.Call
import retrofit2.http.GET

interface AulasAgendadasCall {

    @GET("schedule/:id/student")
    fun getAulasAgendadas() : Call<List<Schedules>>
}