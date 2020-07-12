package com.example.assignment5.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.assignment5.R
import com.example.assignment5.fragments.DetailFragment
import com.example.assignment5.fragments.MainFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragment(MainFragment())

        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.action_home -> {
                        openFragment(MainFragment())
                        return true
                    }
                    R.id.action_favourite -> {
                        openFragment(DetailFragment("Sea Flower Resort"))
                        return true
                    }
                }
                return false
            }
        }
        )





    }



    fun openFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
    }


}
