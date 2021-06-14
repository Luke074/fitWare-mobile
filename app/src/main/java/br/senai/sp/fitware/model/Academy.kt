package br.senai.sp.fitware.model

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName

data class Academy(
    var id: Long,
    @SerializedName("name")
    var academyName: String,
    @SerializedName("cep")
    var academyCep: String,
    @SerializedName("street")
    var academyStreet: String,
    @SerializedName("city")
    var academyCity: String,
//    @SerializedName("")
    var academyImage: Drawable
)