package br.senai.sp.fitware.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import br.senai.sp.fitware.R
import br.senai.sp.fitware.api.RetrofitApi
import br.senai.sp.fitware.api.SessionStudent
import br.senai.sp.fitware.api.rotas.IncludeStudentCall
import br.senai.sp.fitware.model.StudentSchedules
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DialogNewAgendamento : DialogFragment(), OnClickListener{

    private lateinit var sessionStudent: SessionStudent

    lateinit var btnFechar: ImageButton
    lateinit var textDateResult: TextView
    lateinit var textHourResult: TextView
    lateinit var texDurationResult: TextView
    lateinit var textLimitPersonResult: TextView
    lateinit var textLinkResult: TextView
    lateinit var textPersonalNameResult: TextView
    lateinit var buttonInclude: Button

    private var id: Long = 0
    private var date: String = ""
    private var hour: String = ""
    private var duration: String = ""
    private var limit_personal: String = ""
//    private var is_remote: Boolean = false
    private var link: String = ""
    private var personal_name: String = ""

    fun updateDate(date: String) {
        this.date = date
    }
    fun updadteDuration(duration: String){
        this.duration = duration
    }
    fun updadteHour(hour: String) {
        this.hour = hour
    }
    fun updateLimitPersonal(limit_personal: String) {
        this.limit_personal = limit_personal
    }
    fun updateNamePersonal(name: String) {
        this.personal_name = name
    }
    fun updadteId(id: Long) {
        this.id = id
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.customDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_register_agendamento, container, false)

        btnFechar = view.findViewById(R.id.image_button_close)
        btnFechar.setOnClickListener {
            this.dismiss()
        }

        textDateResult = view.findViewById(R.id.data_dialog_value)
        val maskDate = SimpleMaskFormatter("NNNN/NN/NN")
        val mtwDate = MaskTextWatcher(textDateResult, maskDate)
        textDateResult.addTextChangedListener(mtwDate)
        textDateResult.text = date

        textHourResult = view.findViewById(R.id.hour_dialog_value)
        val maskHour = SimpleMaskFormatter("NN:NN")
        val mtwHour = MaskTextWatcher(textHourResult, maskHour)
        textHourResult.addTextChangedListener(mtwHour)
        textHourResult.text = hour

        texDurationResult = view.findViewById(R.id.duracao_dialog_value)
        texDurationResult.text = duration

        textLimitPersonResult = view.findViewById(R.id.limite_pessoas_dialog_value)
        textLimitPersonResult.text = limit_personal

        textPersonalNameResult = view.findViewById(R.id.value_personal_dialog)
        textPersonalNameResult.text = personal_name

        buttonInclude = view.findViewById(R.id.button_confime)
        buttonInclude.setOnClickListener(this)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    private fun includeStudent() {
        sessionStudent = SessionStudent(activity)
        val prefs = sessionStudent.prefs

        val recoveryToken = prefs.getString("TOKEN", "NADA AQUI")
        val recoveryId = id

        var includeStudent: StudentSchedules

        val retrofit = RetrofitApi.getRetrofit()
        val includeCall = retrofit.create(IncludeStudentCall::class.java)

        val call = includeCall.includeAula(recoveryId, "Bearer ${recoveryToken}")

        call.enqueue(object : Callback<StudentSchedules>{
            override fun onResponse(
                call: Call<StudentSchedules>,
                response: Response<StudentSchedules>
            ) {
                if(response.code() == 201 || response.code() == 200){
                    includeStudent = response.body()!!
                    Toast.makeText(activity, "Voce entrou na Aula", Toast.LENGTH_SHORT).show()
                    dismiss()
                }else{
                    Toast.makeText(activity, "Erro na conexão", Toast.LENGTH_SHORT).show()
                    dismiss()
                }
            }

            override fun onFailure(call: Call<StudentSchedules>, t: Throwable) {
                Toast.makeText(activity, "Erro ao se registrar na aula", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button_confime -> {
                includeStudent()
            }
        }
    }

}