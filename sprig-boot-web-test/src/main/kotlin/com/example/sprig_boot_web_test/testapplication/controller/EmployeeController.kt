package com.example.sprig_boot_web_test.testapplication.controller

import com.example.sprig_boot_web_test.testapplication.repository.Task
import com.example.sprig_boot_web_test.testapplication.service.TaskService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping

@RestController
class EmployeeController(private val taskService: TaskService) {

    @GetMapping(value = ["/tasks"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllTasks(): List<Task> = taskService.getAllTasks()

    @GetMapping(value = ["/tasks/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTaskById(@PathVariable("id") taskId: Long): Task =
        taskService.getTaskById(taskId)

    @PostMapping(value = ["/tasks"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createEmployee(@RequestBody payload: Task): Task = taskService.createTask(payload)

    @PutMapping("/tasks/{id}")
    fun updateTaskById(@PathVariable("id") taskId: Long, @RequestBody payload: Task): Task =
        taskService.updateTask(taskId, payload)

    @DeleteMapping("/tasks/{id}")
    fun deleteTask(@PathVariable("id") taskId: Long) = taskService.deleteTaskById(taskId)

}