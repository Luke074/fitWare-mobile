package br.senai.sp.fitware.model

import com.google.gson.annotations.SerializedName
import java.time.Duration
import java.util.*

data class Schedules(
    var id: Long,
    @SerializedName("TraningCategories")
    var category: ArrayList<Category>,
    @SerializedName("PersonalTrainer")
    var personalName: Personal,
    var date: String,
    var hour: String,
    @SerializedName("limit_person")
    var limitPerson: String,
    var duration: String,
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