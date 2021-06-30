package br.senai.sp.fitware.gui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import br.senai.sp.fitware.R
import br.senai.sp.fitware.api.SessionStudent
import br.senai.sp.fitware.fragments.ListSchedulesFragment
import br.senai.sp.fitware.fragments.HomeFragment
import br.senai.sp.fitware.fragments.ProfileFragment
import br.senai.sp.fitware.fragments.SchedulesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener

class HomeActivity : AppCompatActivity(), OnNavigationItemSelectedListener {

    private lateinit var homeFragment: HomeFragment
    private lateinit var profileFragment: ProfileFragment
    private lateinit var schedulesFragment: SchedulesFragment
    private lateinit var aulaOnlineFragment: ListSchedulesFragment
    private lateinit var logooutApp: MenuItem
    private lateinit var sessionStudent: SessionStudent

    private lateinit var bottomNavigation: BottomNavigationView

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeFragment = HomeFragment()
        profileFragment = ProfileFragment()
        schedulesFragment = SchedulesFragment()
        aulaOnlineFragment = ListSchedulesFragment()

        bottomNavigation = findViewById(R.id.bottom_navigation_bottom)
        bottomNavigation.setOnNavigationItemSelectedListener(this)

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Home"
        setSupportActionBar(toolbar)

        sessionStudent = sessionStudent

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .commit()
    }

//    private fun logout() {
//        val intent = Intent(this, SplashScreenActivity::class.java)
//        startActivity(intent)
//        sessionManager.logout()
//        finish()
//    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_home -> {
                setFragment(homeFragment)
                toolbar.title = "Home"
            }
//            R.id.menu_perfil -> {
//                setFragment(profileFragment)
//                toolbar.title = "Perfil"
//            }
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

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}