package br.senai.sp.fitware.gui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.senai.sp.fitware.R
import br.senai.sp.fitware.fragments.EtapaOne

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etapaOne: EtapaOne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etapaOne = EtapaOne()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_register, etapaOne)
            .commit()
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
        }
    }


}
