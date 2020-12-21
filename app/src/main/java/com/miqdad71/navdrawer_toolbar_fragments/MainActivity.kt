package com.miqdad71.navdrawer_toolbar_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.miqdad71.starworks.view.fragments.FirstFragment
import com.miqdad71.starworks.view.fragments.FourthFragment
import com.miqdad71.starworks.view.fragments.SecondFragment
import com.miqdad71.starworks.view.fragments.ThirdFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()
        val fourthFragment = FourthFragment()

        setCurrentFragment(firstFragment)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1 -> setCurrentFragment(firstFragment)
                R.id.miItem2 -> setCurrentFragment(secondFragment)
                R.id.miItem3 -> setCurrentFragment(thirdFragment)
                R.id.miItem4 -> setCurrentFragment(fourthFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragment)
                commit()
            }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}