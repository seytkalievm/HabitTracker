package com.example.habittracker.authorization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.habittracker.R
import com.example.habittracker.databinding.ActivityAuthorizationBinding


class AuthorizationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthorizationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val logInfragment = LogInFragment.newInstance()
        val registerFragment = RegisterFragment.newInstance()

        setCurrentFragment(registerFragment)

    }



    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.activity_authorization_FM, fragment)
            commit()
        }
    }
}