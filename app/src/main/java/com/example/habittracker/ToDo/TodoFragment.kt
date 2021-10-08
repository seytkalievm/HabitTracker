package com.example.habittracker.ToDo

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habittracker.R
import com.example.habittracker.databinding.DailyStepBinding
import com.example.habittracker.databinding.FragmentTodoBinding


class TodoFragment : Fragment() {
    private lateinit var  binding: FragmentTodoBinding
    private lateinit var dailyStepBinding: DailyStepBinding
    private var adapter = ToDoAdapter()
    var i = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentTodoBinding.inflate(inflater, container, false)
        dailyStepBinding = DailyStepBinding.inflate(inflater)
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance() = TodoFragment()
    }

    fun init() = with(binding){
        binding.apply {
            toDoPageRV.layoutManager = LinearLayoutManager(this@TodoFragment.context)
            toDoPageRV.adapter = adapter
            while(i<5){
                val todo = ToDo("Goal $i", i, "Step example", false)
                adapter.add(todo)
                i++
            }
        }

    }


}