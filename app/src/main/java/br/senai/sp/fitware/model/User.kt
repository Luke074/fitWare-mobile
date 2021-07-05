package br.senai.sp.fitware.model

import com.google.gson.annotations.SerializedName

data class User(
    var id: Long,
    @SerializedName("first_name")
    var firstName: String,
    var email: String,
    var celular: String

//    @SerializedName("surname")
//    var surname: String,
)