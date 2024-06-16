package ru.sabramov.springboot.rest.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.sabramov.springboot.rest.service.HelloService


@RestController
class HelloControllerService {

    @Autowired
    private lateinit var helloService: HelloService

    @GetMapping("/tasks", MediaType.APPLICATION_JSON_VALUE)
    fun sayHello() = helloService.sayHello()
}