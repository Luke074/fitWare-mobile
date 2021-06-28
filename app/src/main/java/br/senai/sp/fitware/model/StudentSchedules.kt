package br.senai.sp.fitware.model

import com.google.gson.annotations.SerializedName

data class StudentSchedules(
    var id: Long,
//    var category: String,
    @SerializedName("date")
    var date: String,
    @SerializedName("hour")
    var hours: String,
    @SerializedName("limit_person")
    var limit_person: Int,
    @SerializedName("duration")
    var duration: String
//    var link: String
)