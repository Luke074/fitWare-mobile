package br.senai.sp.fitware.gui

import android.content.Intent
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import br.senai.sp.fitware.R
import br.senai.sp.fitware.api.RetrofitApi
import br.senai.sp.fitware.model.UserLoginModel
import com.google.android.material.textfield.TextInputEditText
import okhttp3.internal.notify

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var textRegister: TextView

    private lateinit var editTextEmail: TextInputEditText
    private lateinit var editTextPassword: TextInputEditText
    private lateinit var buttonEnter: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextEmail = findViewById(R.id.text_input_email)
        editTextPassword = findViewById(R.id.text_input_password)
        buttonEnter = findViewById(R.id.button_entrar)
        buttonEnter.setOnClickListener(this)

        textRegister = findViewById(R.id.text_view_registrese)
        textRegister.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.button_entrar -> {
                if(editTextEmail.text.toString() == "" || editTextPassword.text.toString() == ""){
                    notifyUser("Por favor preencha os campos para efetuar o Login!")
                }else{
                    SingIn()
                }
//                val intentHomeActivity = Intent(this, HomeActivity::class.java)
//                startActivity(intentHomeActivity)
            }
            R.id.text_view_registrese -> {
                val intentRegisterActivity = Intent(this, RegisterActivity::class.java)
                startActivity(intentRegisterActivity)
            }
        }
    }

    private fun SingIn() {
        val user = UserLoginModel(
            email = editTextEmail.text.toString(),
            password = editTextPassword.text.toString()
        )

        val retrofit = RetrofitApi.getRetrofit()

//        val call = retrofit.

    }

    private fun notifyUser(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}