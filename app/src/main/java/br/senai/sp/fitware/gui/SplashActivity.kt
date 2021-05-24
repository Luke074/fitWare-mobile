package br.senai.sp.fitware.gui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import br.senai.sp.fitware.R

class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

    Handler(Looper.getMainLooper()).postDelayed({

        val activityMain = Intent(this, MainActivity::class.java)

        startActivity(activityMain)
        finish()
    }, 2000)

    }
}