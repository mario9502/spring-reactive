package com.mario.springreactive.controller

import com.mario.springreactive.model.dtos.UserDTO
import com.mario.springreactive.model.entities.User
import com.mario.springreactive.service.UserService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/all", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getAllUsers(): Flux<User> {
        return userService.findAll()
    }

    @GetMapping("/{username}", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getUserByUsername(@PathVariable username: String): Mono<User>{
        return userService.findByUsername(username)
    }

    @PostMapping("/add", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun addUser(@RequestBody user: User): Mono<User> {

        return userService.add(user)
    }
}