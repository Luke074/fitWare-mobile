package br.senai.sp.fitware.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApi {
    companion object{
        fun getRetrofit() : Retrofit{
            var retrofit = Retrofit.Builder()
                .baseUrl(UrlApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}