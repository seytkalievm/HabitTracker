package com.example.habittracker.toDo

import androidx.lifecycle.ViewModel
import timber.log.Timber

class ToDoViewModel: ViewModel() {

    var adapter = ToDoAdapter()
    var i = 0
    init {
        Timber.i("ToDo ViewModel created")
        while(i<5){
            val todo = ToDo("Goal $i", i, "Step example", false)
            adapter.add(todo)
            i++
        }

    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ToDo ViewModel destroyed")
    }

}