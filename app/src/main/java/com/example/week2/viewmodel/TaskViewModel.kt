package com.example.week2.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.week2.domain.*

class TaskViewModel : ViewModel() {
    var tasks = mutableStateOf<List<Task>>(emptyList())
        private set
    init {
        tasks.value = MockTasks
    }
    fun addTask(task: Task) {
        tasks.value = addTask(tasks.value, task)
    }
    fun toggleDone(id: Int) {
        tasks.value = toggleDone(tasks.value, id)
    }
    fun removeTask(id: Int) {
        tasks.value = tasks.value.filterNot { it.id == id }
    }
    fun filterByDone(done: Boolean) {
        tasks.value = filterByDone(tasks.value, done)
    }
    fun sortByDueDate() {
        tasks.value = sortByDueDate(tasks.value)
    }
    fun showAll() {
        tasks.value = MockTasks
    }
}
