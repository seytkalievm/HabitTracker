package com.example.habittracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.habittracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.bottomNavigationView.selectedItemId = R.id.toDoPage
        setContentView(binding.root)

        val goalsFragment = GoalsFragment.newInstance()
        val todoFragment = TodoFragment.newInstance()
        val userFragment = UserFragment.newInstance()

        setCurrentFragment(todoFragment)

        binding.bottomNavigationView.setOnItemSelectedListener(){
            when(it.itemId){
                R.id.goalsPage ->{
                    setCurrentFragment(goalsFragment)
                }
                R.id.toDoPage -> {
                    setCurrentFragment(todoFragment)
                }
                R.id.userPage -> {
                    setCurrentFragment(userFragment)
                }
            }
            true
        }
    }


    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.activity_main_frame_layout, fragment)
            commit()
        }
    }
}