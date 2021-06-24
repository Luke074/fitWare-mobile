package br.senai.sp.fitware.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Aulas(
    var id: Long,
    @SerializedName("TraningCategories")
    var category: Category,
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