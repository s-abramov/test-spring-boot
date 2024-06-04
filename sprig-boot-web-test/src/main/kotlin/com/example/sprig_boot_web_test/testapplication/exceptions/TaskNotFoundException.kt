package com.example.sprig_boot_web_test.testapplication.exceptions

import org.springframework.http.HttpStatus

class TaskNotFoundException(httpStatus: HttpStatus, message: String): Exception ()