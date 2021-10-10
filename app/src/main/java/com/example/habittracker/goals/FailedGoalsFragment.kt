package com.example.habittracker.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habittracker.databinding.FragmentFailedGoalsBinding

class FailedGoalsFragment : Fragment() {

    private var _binding: FragmentFailedGoalsBinding? = null
    private val binding get() = _binding!!
    private val adapter = GoalAdapter()
    private var i = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFailedGoalsBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FailedGoalsFragment()

    }

    private fun init() = with(binding){
        binding.apply {
            goalsFailedRV.layoutManager = LinearLayoutManager(this@FailedGoalsFragment.context)
            goalsFailedRV.adapter = adapter
            while (i < 5){
                val goal = Goal("Goal${i}", i + 10, "failed")
                adapter.add_goal(goal)
                i++
            }

        }
    }
}