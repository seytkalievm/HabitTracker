package com.example.habittracker.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.habittracker.R
import com.example.habittracker.databinding.FragmentGoalsBinding


class GoalsFragment : Fragment(R.layout.fragment_goals) {
    private var _binding: FragmentGoalsBinding? = null
    private val binding get() = _binding!!

    val activeGoalsFragment = ActiveGoalsFragment.newInstance()
    val failedGoalsFragment = FailedGoalsFragment.newInstance()
    val completedGoalsFragment = CompletedGoalsFragment.newInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        _binding = FragmentGoalsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goalsTopNavigationView.selectedItemId = R.id.active
        setCurrentFragment(activeGoalsFragment)

        binding.goalsTopNavigationView.setOnItemSelectedListener() {
            when (it.itemId) {
                R.id.active -> {
                    setCurrentFragment(activeGoalsFragment)
                }
                R.id.failed -> {
                    setCurrentFragment(failedGoalsFragment)
                }
                R.id.completed -> {
                    setCurrentFragment(completedGoalsFragment)
                }
            }
            true

        }
    }


    private fun setCurrentFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_goals_frame_layout, fragment)
            commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = GoalsFragment()
    }


}