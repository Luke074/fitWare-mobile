package br.senai.sp.fitware.model


data class StudentSchedules(
    var id: Long,
    var category: String,
    var date: String,
    var hours: String,
    var limit_person: Int,
    var duration: String,
    var link: String
)