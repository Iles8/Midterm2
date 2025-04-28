package com.example.project1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project1.data.Task
import com.example.project1.databinding.ActivityMainBinding
import com.example.project1.presentation.TaskAdapter
import com.example.project1.presentation.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val taskViewModel: TaskViewModel by viewModels()
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        taskViewModel.tasks.observe(this) { tasks ->
            taskAdapter.submitList(tasks)
        }

        binding.btnAddTask.setOnClickListener {
            val title = binding.etTaskTitle.text.toString()
            if (title.isNotEmpty()) {
                val task = Task(title = title)
                taskViewModel.addTask(task)
                binding.etTaskTitle.text.clear()
            }
        }
        binding.btnGoToAnimation.setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }
    }

    private fun setupRecyclerView() {
        taskAdapter = TaskAdapter()
        binding.rvTasks.apply {
            adapter = taskAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}
