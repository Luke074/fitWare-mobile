package br.senai.sp.fitware.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import br.senai.sp.fitware.R

class DialogNewAgendamento : DialogFragment() {

    lateinit var btnFechar: ImageButton
    lateinit var textDateResult: TextView
    lateinit var textHourResult: TextView
    lateinit var textLimitPersonResult: TextView
    lateinit var textLinkResult: TextView
    lateinit var textPersonalNameResult: TextView

    private var date: String = ""
    private var hour: String = ""
    private var limit_personal: String = ""
//    private var is_remote: Boolean = false
    private var link: String = ""
    private var personal_name: String = ""

    fun updateDate(date: String) {
        this.date = date
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

        textDateResult = view.findViewById(R.id.value_data_include)
        textHourResult = view.findViewById(R.id.value_hour_include)
        textLimitPersonResult = view.findViewById(R.id.value_limite_pessoas_include)
        textPersonalNameResult = view.findViewById(R.id.value_personal_agendamento)
//        textLinkResult = view.findViewById(R.id.value_link_agendamento)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        includeStudent()
    }

    private fun includeStudent() {
        TODO("Not yet implemented")
    }
}