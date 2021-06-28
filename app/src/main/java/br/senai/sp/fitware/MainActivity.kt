package br.senai.sp.fitware.gui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import br.senai.sp.fitware.R
import br.senai.sp.fitware.api.rotas.LoginCall
import br.senai.sp.fitware.api.RetrofitApi
import br.senai.sp.fitware.api.SessionStudent
import br.senai.sp.fitware.model.Token
import br.senai.sp.fitware.model.UserLoginModel
import br.senai.sp.fitware.model.UserToken
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var textRegister: TextView

    private lateinit var editTextEmail: TextInputEditText
    private lateinit var editTextPassword: TextInputEditText
    private lateinit var buttonEnter: Button
    private lateinit var token: Token
    lateinit var sessionStudent: SessionStudent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextEmail = findViewById(R.id.text_input_email)
        editTextPassword = findViewById(R.id.text_input_password)
        buttonEnter = findViewById(R.id.button_entrar)
        buttonEnter.setOnClickListener(this)

        textRegister = findViewById(R.id.text_view_registrese)
        textRegister.setOnClickListener(this)

        sessionStudent = SessionStudent(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button_entrar -> {
                if (editTextEmail.text.toString() == "" || editTextPassword.text.toString() == "") {
                    notifyUser("Por favor preencha os campos para efetuar o Login!")
                } else {
                    SingIn()
                }
            }
            R.id.text_view_registrese -> {
                val intentRegisterActivity = Intent(this, RegisterActivity::class.java)
                startActivity(intentRegisterActivity)
            }
        }
    }

    fun SingIn() {
        val user = UserLoginModel(
            email = editTextEmail.text.toString(),
            password = editTextPassword.text.toString()
        )

        val retrofit = RetrofitApi.getRetrofit()
        val loginCall = retrofit.create(LoginCall::class.java)

        val call = loginCall.singIn(user)

        call.enqueue(object : Callback<Token> {
            override fun onResponse(
                call: Call<Token>,
                response: Response<Token>
            ) {
                token = response.body()!!

                if(response.code().toString() == "201" ||
                    response.code().toString() == "200"){

//                    val prefs: SharedPreferences = this@MainActivity.getSharedPreferences(
//                        "preferencias",
//                        Context.MODE_PRIVATE
//                    )
//                    prefs.edit().putString("TOKEN", token.token).apply()
//                    prefs.edit().putString("ID", token.user.userId.toString()).apply()

                    sessionStudent.saveToken(token.token)
                    sessionStudent.saveId(token.user.userId)

                    goHome()
//
//                    Log.i("XPTO", token.token)
//                    Log.i("XPTO", token.user.userId.toString())
                }else{
                    Toast.makeText(this@MainActivity,
                        "email ou senha incorreto", Toast.LENGTH_LONG)
                        .show()
                    Log.e("TESTE", token.toString())
                }
            }

            override fun onFailure(call: Call<Token>, t: Throwable) {
                Toast.makeText(this@MainActivity, "A conexão falhou :(", Toast.LENGTH_LONG).show()
                Log.e("ERRO_CONEXÃO", t.message.toString())
            }

        })
    }

    private fun goHome() {
        val intentHomeActivity = Intent(this, HomeActivity::class.java)
        startActivity(intentHomeActivity)
    }

    private fun notifyUser(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
