package com.bangkit.skutapp.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bangkit.skutapp.R

import com.bangkit.skutapp.databinding.ActivityMainBinding
import com.bangkit.skutapp.model.user.UserModel
import com.bangkit.skutapp.view.home.HomeFragment
import com.bangkit.skutapp.view.login.LoginActivity

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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