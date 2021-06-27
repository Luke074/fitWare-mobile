package br.senai.sp.fitware.model

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName

data class Academy(
    var id: Long,
    @SerializedName("name")
    var academyName: String,
    @SerializedName("email")
    var emailAcademy: String,
    @SerializedName("AddressAcademy")
    var addressAcademy: AddresAcademy
)