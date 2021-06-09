package br.senai.sp.fitware.model

import android.graphics.drawable.Drawable

class User(
    var id: Long,
    var userImage: Drawable,
    var userFirstName: String,
    var userSecondyName: String,
    var userEmail: String,
    var userCpf: String,
    var userPeso: String,
    var userAltura: String,
    var userSexo: String,
    var userDateNascimento: String,
    var userCity: String,
    var userState: String,
    var userAdressNumber: String,
    var userAdress: String,
    var userCep: String
)