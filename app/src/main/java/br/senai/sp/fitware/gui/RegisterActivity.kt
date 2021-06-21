package br.senai.sp.fitware.gui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.senai.sp.fitware.R
import br.senai.sp.fitware.api.RetrofitApi
import br.senai.sp.fitware.api.rotas.RegisterCall
import br.senai.sp.fitware.model.UserRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity(), View.OnClickListener , AdapterView.OnItemSelectedListener{

    private lateinit var editTextFirstName: EditText
    private lateinit var editTextSecondyName: EditText
    private lateinit var editTextDataNascimento: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextCpf: EditText
    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var editTextCity: EditText
    private lateinit var editTextState: EditText
    private lateinit var editTextStreet: EditText
    private lateinit var editTextCep: EditText
    private lateinit var editTextNumber: EditText
    private lateinit var editTextCell: EditText

    private lateinit var spinnerSexo: Spinner
    private lateinit var msgSpinner: TextView
    private val sexoList = listOf<String>("M", "F", "O")

    private lateinit var buttonRegisterConfirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editTextFirstName = findViewById(R.id.register_fistname)
        editTextSecondyName = findViewById(R.id.register_secondyname)
        editTextDataNascimento = findViewById(R.id.register_datanascimento)
        editTextEmail = findViewById(R.id.register_email)
        editTextPassword = findViewById(R.id.register_password)
        editTextCpf = findViewById(R.id.register_cpf)
        editTextPeso = findViewById(R.id.register_weight)
        editTextAltura = findViewById(R.id.register_height)
        editTextCity = findViewById(R.id.register_city)
        editTextState = findViewById(R.id.register_state)
        editTextStreet = findViewById(R.id.register_street)
        editTextCep = findViewById(R.id.register_cep)
        editTextNumber = findViewById(R.id.register_number)
        editTextCell = findViewById(R.id.register_cell)

        buttonRegisterConfirm = findViewById(R.id.button_register_end)
        buttonRegisterConfirm.setOnClickListener(this)

        msgSpinner = findViewById(R.id.msg_spinner)
        spinnerSexo = findViewById(R.id.spinner)
        spinnerSexo.onItemSelectedListener

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sexoList)
        spinnerSexo.adapter = arrayAdapter
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        msgSpinner.text = "Selected : "+ sexoList[position]
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button_register_end -> {
                Register()
            }
        }
    }

    private fun Register() {
        val register = UserRegister(
            userFirstName = editTextFirstName.text.toString(),
            userSecondyName = editTextSecondyName.text.toString(),
            userDateNascimento = editTextDataNascimento.text.toString(),
            userEmail = editTextEmail.text.toString(),
            userPassword = editTextPassword.text.toString(),
            userCpf = editTextCpf.text.toString(),
            userPeso = editTextPeso.text.toString().toDouble(),
            userAltura = editTextAltura.text.toString().toDouble(),
            userCity = editTextCity.text.toString(),
            userState = editTextState.text.toString(),
            userAdress = editTextStreet.text.toString(),
            userCep = editTextCep.text.toString(),
            userCelular = editTextCell.text.toString(),
            userNumber = editTextNumber.text.toString()
        )

        val retrofit = RetrofitApi.getRetrofit()
        val registerCall = retrofit.create(RegisterCall::class.java)

        val call = registerCall.register(register)

        call.enqueue(object : Callback<UserRegister> {
            override fun onResponse(call: Call<UserRegister>, response: Response<UserRegister>) {
                val responseBody = response.body()

                if(response.code().toString() == "201" ||
                    response.code().toString() == "200"){

                    goLogin()
                }else{
                    Toast.makeText(this@RegisterActivity,
                        "alguma informação esta incorreta", Toast.LENGTH_LONG)
                        .show()
                    Log.e("TESTE", responseBody.toString())
                }
            }

            override fun onFailure(call: Call<UserRegister>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "A conexão falhou :(", Toast.LENGTH_LONG).show()
                Log.e("ERRO_CONEXÃO", t.message.toString())
            }

        })
    }

    private fun goLogin() {
        val intentHomeActivity = Intent(this, MainActivity::class.java)
        startActivity(intentHomeActivity)
    }

}
