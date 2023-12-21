package com.mete.security.entity

import com.mete.security.dto.Role
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "users")
data class User(
    @Id
    val id: UUID = UUID.randomUUID(),
    @Column(unique = true)
    val username: String,
    val password: String,
    val email: String,
    val phoneNumber: String,
    @ElementCollection
    val roles: MutableSet<Role> = mutableSetOf()
)
