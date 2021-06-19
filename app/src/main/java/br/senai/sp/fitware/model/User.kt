package br.senai.sp.fitware.model

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName

data class User(
    var id: Long,
//    var userImage: Drawable,
    @SerializedName("first_name")
    var userFirstName: String,
    @SerializedName("surname")
    var userSecondyName: String,
    @SerializedName("email")
    var userEmail: String,
    @SerializedName("cpf")
    var userCpf: String,
    @SerializedName("weight")
    var userPeso: String,
    @SerializedName("height")
    var userAltura: String,
//    var userSexo: String,
    @SerializedName("birth_date")
    var userDateNascimento: String,
    @SerializedName("city")
    var userCity: String,
    @SerializedName("state")
    var userState: String,
    @SerializedName("street")
    var userAdress: String,
    @SerializedName("cep")
    var userCep: String
)