package com.example.proyectobasejetpackcompose.addtasks.data.di

import android.content.Context
import androidx.room.Room
import com.example.proyectobasejetpackcompose.addtasks.data.TaskDao
import com.example.proyectobasejetpackcompose.addtasks.data.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun providesTaskDao(todoDatabase: TodoDatabase):TaskDao{
        return todoDatabase.taskDao()
    }


    @Provides
    @Singleton
    fun providesTodoDatabase(@ApplicationContext appContext: Context):TodoDatabase{
        return Room.databaseBuilder(appContext, TodoDatabase::class.java ,"TaskDatabase").build()
    }


}