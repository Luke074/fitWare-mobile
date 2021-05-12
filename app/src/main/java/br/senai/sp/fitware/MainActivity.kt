package br.senai.sp.fitware.gui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import br.senai.sp.fitware.R
import br.senai.sp.fitware.fragments.HomeFragment
import br.senai.sp.fitware.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener {

    private lateinit var homeFragment: HomeFragment
    private lateinit var profileFragment: ProfileFragment

    private lateinit var toolbar: Toolbar

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeFragment = HomeFragment()
        profileFragment = ProfileFragment()

        bottomNavigation = findViewById(R.id.bottom_navigation_bottom)
        bottomNavigation.setOnNavigationItemSelectedListener(this)

//        toolbar = findViewById(R.id.toolbar)
//        toolbar.setTitle("Home")
//        setSupportActionBar(toolbar)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_home -> {
                setFragment(homeFragment)
            }
            R.id.menu_perfil -> {
                setFragment(profileFragment)
            }
        }

        val selectedMenu = bottomNavigation.menu.findItem(item.itemId)
        selectedMenu.setChecked(true)

        return true
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}