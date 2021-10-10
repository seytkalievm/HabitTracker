package com.example.habittracker.toDo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habittracker.databinding.DailyStepBinding
import com.example.habittracker.databinding.FragmentTodoBinding
import timber.log.Timber


class TodoFragment : Fragment() {
    private lateinit var  binding: FragmentTodoBinding
    private lateinit var dailyStepBinding: DailyStepBinding

    private lateinit var viewModel: ToDoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentTodoBinding.inflate(inflater, container, false)

        dailyStepBinding = DailyStepBinding.inflate(inflater)
        Timber.i("Called viewModelProvider")
        viewModel = ViewModelProviders.of(this).get(ToDoViewModel::class.java)

        init()
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        init()
    }

    override fun onResume() {
        super.onResume()
        init()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onPause() {
        super.onPause()

    }

    companion object {
        @JvmStatic
        fun newInstance() = TodoFragment()
    }

    fun init() {
        binding.apply {
            toDoPageRV.layoutManager = LinearLayoutManager(this@TodoFragment.context)
            toDoPageRV.adapter = viewModel.adapter
        }
    }


}