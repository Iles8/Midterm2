package com.example.project1.data

import androidx.lifecycle.LiveData
import com.example.project1.domain.TaskRepository

class TaskRepositoryImpl(private val dao: TaskDao) : TaskRepository {
    override suspend fun insert(task: Task) = dao.insert(task)
    override fun getAllTasks(): LiveData<List<Task>> = dao.getAllTasks()
}
