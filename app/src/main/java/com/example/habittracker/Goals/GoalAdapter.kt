package com.example.habittracker.Goals

import android.content.res.ColorStateList
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.R
import com.example.habittracker.databinding.GoalBinding
import java.security.AccessController.getContext

class GoalAdapter: RecyclerView.Adapter<GoalAdapter.GoalHolder>() {
    val goalsList = ArrayList<Goal>()
    class GoalHolder(view: View): RecyclerView.ViewHolder(view){
        val view = view
        var binding = GoalBinding.bind(view)

        fun bind(goal: Goal) = with(binding){
            progressBarPB.progress = goal.done
            val progress = view.context.getString(R.string.completedOutOf21, goal.done)
            goalsCompletedTW.text = progress

            val green = ContextCompat.getColor(view.context, R.color.pb_green)
            val red = ContextCompat.getColor(view.context, R.color.pb_red)
            val blue = ContextCompat.getColor(view.context, R.color.pb_blue)
            if (goal.status == "completed") {
                progressBarPB.progressTintList = ColorStateList.valueOf(green)
            }
            if (goal.status == "active"){
                progressBarPB.progressTintList = ColorStateList.valueOf(blue)
            }
            if(goal.status == "failed"){
                progressBarPB.progressTintList = ColorStateList.valueOf(red)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.goal, parent, false)
        return GoalHolder(view)

    }

    override fun onBindViewHolder(holder: GoalHolder, position: Int) {
        holder.bind(goalsList[position])
    }

    override fun getItemCount(): Int {
        return goalsList.size
    }

    fun add_goal(goal: Goal){
        goalsList.add(goal)
        notifyDataSetChanged()
    }
}
