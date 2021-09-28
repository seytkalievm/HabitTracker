package com.example.habittracker.Goals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habittracker.R
import com.example.habittracker.databinding.FragmentCompletedGoalsBinding
import com.example.habittracker.databinding.FragmentGoalsBinding
import com.example.habittracker.databinding.GoalBinding

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
                val goal = Goal("Goal${i}", i, "completed")
                adapter.add_goal(goal)
                i++
            }

        }
    }
}