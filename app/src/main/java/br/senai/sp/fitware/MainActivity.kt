package br.senai.sp.fitware.gui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import br.senai.sp.fitware.R
import br.senai.sp.fitware.fragments.AulaOnlineFragment
import br.senai.sp.fitware.fragments.HomeFragment
import br.senai.sp.fitware.fragments.ProfileFragment
import br.senai.sp.fitware.fragments.SchedulesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener {

    private lateinit var homeFragment: HomeFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var schedulesFragment: SchedulesFragment
    private lateinit var aulaOnlineFragment: AulaOnlineFragment

    private lateinit var bottomNavigation: BottomNavigationView

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeFragment = HomeFragment()
        profileFragment = ProfileFragment()
        schedulesFragment = SchedulesFragment()
        aulaOnlineFragment = AulaOnlineFragment()

        bottomNavigation = findViewById(R.id.bottom_navigation_bottom)
        bottomNavigation.setOnNavigationItemSelectedListener(this)

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Home"
        setSupportActionBar(toolbar)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_home -> {
                setFragment(homeFragment)
                toolbar.title = "Home"
            }
            R.id.menu_perfil -> {
                setFragment(profileFragment)
                toolbar.title = "Perfil"
            }
            R.id.menu_agendamento -> {
                setFragment(schedulesFragment)
                toolbar.title = "Agendamento"
            }
            R.id.menu_aulas_online -> {
                setFragment(aulaOnlineFragment)
                toolbar.title = "Aula Online"
            }
        }

        val selectedMenu = bottomNavigation.menu.findItem(item.itemId)
        selectedMenu.isChecked = true

        return true
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
=======
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
>>>>>>> e9d9e8a5237bce7d6f0f9d123aa9c4731cefa67a
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