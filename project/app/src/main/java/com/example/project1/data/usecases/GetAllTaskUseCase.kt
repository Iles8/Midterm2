package com.example.project1.data.usecases

import androidx.lifecycle.LiveData
import com.example.project1.data.Task
import com.example.project1.domain.TaskRepository

class GetAllTasksUseCase(private val repository: TaskRepository) {
    operator fun invoke(): LiveData<List<Task>> = repository.getAllTasks()
}
