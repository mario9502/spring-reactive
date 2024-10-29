package com.mario.springreactive.service

import com.mario.springreactive.model.entities.User
import com.mario.springreactive.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.time.Duration

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun add(user: User): Mono<User>{

        return userRepository.save(user)
            .onErrorResume { throw IllegalArgumentException("User already exist") }
    }

    fun findAll(): Flux<User> {

        return userRepository.findAll().delayElements(Duration.ofSeconds(3))
    }

    fun findByUsername(username: String): Mono<User> {

        val findByUsername = userRepository.findUserByUsername(username)

        return findByUsername.defaultIfEmpty(User(0, "No","Such", "User"))
    }

    fun mapUser(user: User): User {

        return user.copy()
    }
}