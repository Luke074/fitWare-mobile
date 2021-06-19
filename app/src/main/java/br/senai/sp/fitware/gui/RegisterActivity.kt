package br.senai.sp.fitware.gui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.senai.sp.fitware.R
import br.senai.sp.fitware.fragments.EtapaOne
import br.senai.sp.fitware.fragments.EtapaTwo
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener

class RegisterActivity : AppCompatActivity(), OnNavigationItemSelectedListener {

    private lateinit var etapaOne: EtapaOne
    private lateinit var etapaTwo: EtapaTwo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etapaOne = EtapaOne()
        etapaTwo = EtapaTwo()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_register, etapaOne)
            .commit()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.button_next_two -> {
                setFragment(etapaTwo)
            }
        }

        return true
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}
