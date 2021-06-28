package br.senai.sp.fitware.model

import com.google.gson.annotations.SerializedName

data class UserToken(
    @SerializedName("id")
    var userId: Long = 0,
    var userPerfil: String = "",
    var userName: String = ""
)
