package br.senai.sp.fitware.model

import com.google.gson.annotations.SerializedName

data class UserLoginModel(
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String
)
