package br.senai.sp.fitware.model

data class ArrayStudent(
    var Schedules: ArrayList<StudentSchedules>
)

class StudentSchedules(
    var id: Long,
    var date: String,
    var hour: String,
    var limit_person: Int,
    var duration: String,
    var is_remote: Boolean,
    var link: String
)