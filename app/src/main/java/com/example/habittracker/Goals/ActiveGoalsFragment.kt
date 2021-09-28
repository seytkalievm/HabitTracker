package com.example.habittracker.Goals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habittracker.R
import com.example.habittracker.databinding.FragmentActiveGoalsBinding
import com.example.habittracker.databinding.FragmentCompletedGoalsBinding


class ActiveGoalsFragment : Fragment() {

    private var _binding: FragmentActiveGoalsBinding? = null
    private val binding get() = _binding!!
    private val adapter = GoalAdapter()
    private var i = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActiveGoalsBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ActiveGoalsFragment()
    }

    private fun init() = with(binding){
        binding.apply {
            goalsActiveRV.layoutManager = LinearLayoutManager(this@ActiveGoalsFragment.context)
            goalsActiveRV.adapter = adapter
            while (i < 5){
                val goal = Goal("Goal${i}", i, "active")
                adapter.add_goal(goal)
                i++
            }

        }
    }
}