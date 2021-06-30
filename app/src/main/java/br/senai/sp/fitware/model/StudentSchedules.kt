package br.senai.sp.fitware.model

import com.google.gson.annotations.SerializedName

data class Student(
    var id: Long,
    var first_name: String,
    var Schedules: StudentSchedules
)

class StudentSchedules(
    var id: Long,
    @SerializedName("date")
    var date: String,
    @SerializedName("hour")
    var hours: String,
    var limit_person: Int,
    var duration: String,
    var is_remote: Boolean,
    var link: String
)