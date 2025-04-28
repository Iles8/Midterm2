package com.example.project1.di

import android.content.Context
import androidx.room.Room
import com.example.project1.data.AppDatabase
import com.example.project1.data.TaskDao
import com.example.project1.data.TaskRepositoryImpl
import com.example.project1.data.usecases.AddTaskUseCase
import com.example.project1.data.usecases.GetAllTasksUseCase
import com.example.project1.domain.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "task_database")
            .build()

    @Provides
    fun provideTaskDao(db: AppDatabase): TaskDao = db.taskDao()

    @Provides
    fun provideRepository(dao: TaskDao): TaskRepository = TaskRepositoryImpl(dao)

    @Provides
    fun provideAddTaskUseCase(repository: TaskRepository): AddTaskUseCase =
        AddTaskUseCase(repository)

    @Provides
    fun provideGetAllTasksUseCase(repository: TaskRepository): GetAllTasksUseCase =
        GetAllTasksUseCase(repository)
}
