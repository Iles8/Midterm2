package com.example.project1.domain

import androidx.lifecycle.LiveData
import com.example.project1.data.Task

interface TaskRepository {
    suspend fun insert(task: Task)
    fun getAllTasks(): LiveData<List<Task>>
}
