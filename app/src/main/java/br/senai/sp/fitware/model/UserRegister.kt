package br.senai.sp.fitware.model

import com.google.gson.annotations.SerializedName

data class UserRegister(
    @SerializedName("first_name")
    var userFirstName: String,
    @SerializedName("surname")
    var userSecondyName: String,
    @SerializedName("birth_date")
    var userDateNascimento: String,
    @SerializedName("email")
    var userEmail: String,
    @SerializedName("password")
    var userPassword: String,
    @SerializedName("cpf")
    var userCpf: String,
    @SerializedName("weight")
    var userPeso: Double,
    @SerializedName("height")
    var userAltura: Double,
    @SerializedName("city")
    var userCity: String,
    @SerializedName("state")
    var userState: String,
    @SerializedName("street")
    var userAdress: String,
    @SerializedName("cep")
    var userCep: String,
    @SerializedName("number")
    var userNumber: String,
    @SerializedName("gender")
    var userCelular: String
)