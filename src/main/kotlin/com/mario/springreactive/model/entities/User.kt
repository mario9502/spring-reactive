package com.mario.springreactive.model.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "users")
data class User(

    @Id
    val id: Long?,
    @Column
    val username: String,
    @Column
    val firstName: String,
    @Column
    val lastName: String
) {

    constructor(): this(null, "default", "default", "default")
}