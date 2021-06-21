package br.senai.sp.fitware.model

data class Token (
    var user: UserToken = UserToken(0, "", ""),
    var token: String = ""
)