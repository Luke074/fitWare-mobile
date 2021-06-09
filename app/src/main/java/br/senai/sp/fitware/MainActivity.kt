package br.senai.sp.fitware.gui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import br.senai.sp.fitware.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonEnter: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonEnter = findViewById(R.id.button_entrar)
        buttonEnter.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.button_entrar -> {
                val intentHomeActivity = Intent(this, HomeActivity::class.java)
                startActivity(intentHomeActivity)
            }

        }
    }

}