package br.senai.sp.fitware.api.rotas

import br.senai.sp.fitware.model.Academy
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface AcademyCall {

    @GET("academy")
    fun getAcademy(@Header("Authorization") token: String?) : Call<List<Academy>>

}