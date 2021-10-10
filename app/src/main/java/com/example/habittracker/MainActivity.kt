package com.example.habittracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.habittracker.databinding.ActivityMainBinding
import com.example.habittracker.goals.GoalsFragment
import com.example.habittracker.toDo.TodoFragment
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    val goalsFragment = GoalsFragment.newInstance()
    val todoFragment = TodoFragment.newInstance()
    val userFragment = UserFragment.newInstance()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.i("onCreate called")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.bottomNavigationView.selectedItemId = R.id.toDoPage
        setContentView(binding.root)


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

    override fun onPause() {
        super.onPause()
        Timber.i("onPause called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume called")
    }

    override fun onDestroy() {
        Timber.i("onDestroy called")
        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("OnRestart called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop called")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart called")

    }


    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.activity_main_frame_layout, fragment)
            commit()
        }
    }

}