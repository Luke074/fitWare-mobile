package br.senai.sp.fitware.gui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import br.senai.sp.fitware.R

class DialogNewAgendamento : DialogFragment() {

    lateinit var btnFechar: ImageButton


    fun updateData(){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.customDialog)
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