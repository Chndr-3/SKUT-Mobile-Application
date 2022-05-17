package com.bangkit.skutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import androidx.viewpager2.widget.ViewPager2
import com.bangkit.skutapp.databinding.ActivityMainBinding
import com.bangkit.skutapp.model.ViewPagerItem
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        selection()


    }

    private fun selection() {
        loadFragment(HomeFragment())
        binding.bottomNavigationView.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                }
//                R.id.camera -> {
//                    loadFragment(ChatFragment())
//                    return@setOnNavigationItemReselectedListener
//                }
//                R.id.profile -> {
//                    loadFragment(SettingFragment())
//                    return@setOnNavigationItemReselectedListener
//                }
            }
        }
    }
        private fun loadFragment(fragment: Fragment){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

}