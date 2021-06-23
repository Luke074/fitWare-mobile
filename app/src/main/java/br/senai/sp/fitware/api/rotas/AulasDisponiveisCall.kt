package br.senai.sp.fitware.api.rotas

import br.senai.sp.fitware.model.Aulas
import retrofit2.Call
import retrofit2.http.GET

interface AulasDisponiveisCall {

    @GET("schedule")
    fun getAulasAgendadas() : Call<List<Aulas>>

}