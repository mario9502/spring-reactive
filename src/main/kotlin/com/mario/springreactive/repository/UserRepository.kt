package com.mario.springreactive.repository

import com.mario.springreactive.model.entities.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface UserRepository: ReactiveCrudRepository<User, Long> {

    fun findUserByUsername(username: String): Mono<User>
}