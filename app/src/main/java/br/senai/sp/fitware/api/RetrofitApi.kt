package br.senai.sp.fitware.api

import br.senai.sp.fitware.api.UrlApi.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApi {
    companion object{
        fun getRetrofit() : Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

//            return retrofit
        }
    }
}