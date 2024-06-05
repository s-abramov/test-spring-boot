package com.example.sprig_boot_web_test.testapplication.service

import com.example.sprig_boot_web_test.testapplication.exceptions.TaskNotFoundException
import com.example.sprig_boot_web_test.testapplication.repository.Task
import com.example.sprig_boot_web_test.testapplication.repository.TaskRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepository: TaskRepository) {
    // Получаем список всех задач
    fun getAllTasks(): List<Task> = taskRepository.findAll()

    //Получаем задачу по taskId
    fun getTaskById(taskId: Long): Task {
        return taskRepository.findByIdOrNull(taskId)
            ?: throw TaskNotFoundException(HttpStatus.NOT_FOUND, "Задача с $taskId не найдена")
    }

    //Создаем задачу
    fun createTask(task: Task): Task = taskRepository.save(task)

    //Обновляем задачу, если она найдена, если нет выбрасываем исключение
    fun updateTask(taskId: Long, task: Task): Task {
        return if (taskRepository.existsById(taskId)) {
            taskRepository.save(
                Task(
                    id = task.id,
                    name = task.name
                )
            )
        } else throw TaskNotFoundException(HttpStatus.NOT_FOUND, "Задача с $taskId не найдена")
    }

    //Удаляем задачу
    fun deleteTaskById(taskId: Long) {
        return if (taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId)
        } else throw TaskNotFoundException(HttpStatus.NOT_FOUND, "Задача с $taskId не найдена")
    }
}