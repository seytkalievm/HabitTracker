package com.example.habittracker.toDo

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.R
import com.example.habittracker.databinding.DailyStepBinding

class ToDoAdapter: RecyclerView.Adapter<ToDoAdapter.ToDoHolder>() {
    val toDoList = ArrayList<ToDo>()

    class ToDoHolder(view: View): RecyclerView.ViewHolder(view){
        val view = view
        var binding = DailyStepBinding.bind(view)

        fun bind(toDo: ToDo) = with(binding){
            GoalNameTW.text = toDo.title
            currentStepNumberTW.text = view.context.getString(R.string.step, toDo.step)
            currentStepTW.text = toDo.toDo


            val green = ContextCompat.getColor(view.context, R.color.pb_green)
            val red = ContextCompat.getColor(view.context, R.color.pb_red)
            val gray = ContextCompat.getColor(view.context, R.color.not_selected_gray)

            binding.doneIB.setOnClickListener{

                if (binding.doneIB.imageTintList == ColorStateList.valueOf(gray)){
                    binding.doneIB.imageTintList = ColorStateList.valueOf(green)
                    binding.notDoneIB.imageTintList = ColorStateList.valueOf(gray)
                }
                else{
                    binding.doneIB.imageTintList = ColorStateList.valueOf(gray)
                    binding.notDoneIB.imageTintList = ColorStateList.valueOf(gray)

                }

            }

            binding.notDoneIB.setOnClickListener{
                if (binding.notDoneIB.imageTintList == ColorStateList.valueOf(gray)){
                    binding.notDoneIB.imageTintList = ColorStateList.valueOf(red)
                    binding.doneIB.imageTintList = ColorStateList.valueOf(gray)
                }
                else{
                    binding.doneIB.imageTintList = ColorStateList.valueOf(gray)
                    binding.notDoneIB.imageTintList = ColorStateList.valueOf(gray)

                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.daily_step, parent, false)
        return ToDoAdapter.ToDoHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
        holder.bind(toDoList[position])

    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    fun add(toDo: ToDo){
        toDoList.add(toDo)
        notifyDataSetChanged()
    }
}