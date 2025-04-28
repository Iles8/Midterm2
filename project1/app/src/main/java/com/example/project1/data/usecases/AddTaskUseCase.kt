package com.example.project1.data.usecases

import androidx.lifecycle.LiveData
import com.example.project1.data.Task
import com.example.project1.domain.TaskRepository

class AddTaskUseCase(private val repository: TaskRepository) {
    suspend operator fun invoke(task: Task) {
        repository.insert(task)
    }
}

