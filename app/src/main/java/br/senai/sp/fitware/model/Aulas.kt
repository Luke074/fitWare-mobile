package br.senai.sp.fitware.model

import com.google.gson.annotations.SerializedName

data class Aulas(
    var id: Long,
    @SerializedName("personal_name")
    var namePersonal: String,
    var duration: String,
    @SerializedName("limit_person")
    var limitPerson: String,
    var link: String
)