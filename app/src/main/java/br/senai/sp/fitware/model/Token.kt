package br.senai.sp.fitware.model

import com.google.gson.annotations.SerializedName

data class Token (
    var user: UserToken = UserToken( 0,"", ""),
    var token: String = ""
)