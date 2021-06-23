package br.senai.sp.fitware.model

import com.google.gson.annotations.SerializedName

data class Aulas(
    var id: Long,
    @SerializedName("TraningCategories")
    var category: String,
    @SerializedName("PersonalTrainer")
    var personal: String,
    var date: String,
    var hour: String,
    @SerializedName("limit_person")
    var limitPerson: String,
    var is_remote: Boolean,
    var link: String
)

//class Schedules(
//    var id: Long,
//    var category: String,
//    var date: String,
//    var hours: String,
//    var personalTrainer: String
//)