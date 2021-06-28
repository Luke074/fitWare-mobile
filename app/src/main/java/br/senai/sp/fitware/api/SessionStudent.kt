package br.senai.sp.fitware.api

import android.content.Context
import android.content.SharedPreferences
import br.senai.sp.fitware.R

class SessionStudent(context: Context?) {

    companion object{
        const val TOKEN_STUDENT = "TOKEN"
        const val ID_STUDENT = "ID"
    }

    val prefs: SharedPreferences =
        context!!.getSharedPreferences(context.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )

    fun saveToken(token: String){
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putString(TOKEN_STUDENT, token)
        editor.apply()
    }

    fun returnToken(): String? {
        return prefs.getString(TOKEN_STUDENT, null)
    }

    fun logout() {
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.clear()
        editor.apply()
    }

//    prefs.edit().putString("TOKEN", token.token).apply()
//    prefs.edit().putString("ID", token.user.userId.toString()).apply()
}