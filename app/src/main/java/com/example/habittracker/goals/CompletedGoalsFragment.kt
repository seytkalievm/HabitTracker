package com.example.habittracker.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habittracker.databinding.FragmentCompletedGoalsBinding

class CompletedGoalsFragment : Fragment() {

    private var _binding: FragmentCompletedGoalsBinding? = null
    private val binding get() = _binding!!
    private val adapter = GoalAdapter()
    private var i = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompletedGoalsBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CompletedGoalsFragment()
    }

    private fun init() = with(binding){
        binding.apply {
            goalsCompletedRV.layoutManager = LinearLayoutManager(this@CompletedGoalsFragment.context)
            goalsCompletedRV.adapter = adapter
            while (i < 5){
                val goal = Goal("Goal $i ", 21, "completed")
                adapter.add_goal(goal)
                i++
            }

        }
    }
}