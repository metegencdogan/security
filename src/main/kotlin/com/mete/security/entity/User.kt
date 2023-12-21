package com.mete.security.entity

import com.mete.security.dto.Role
import jakarta.persistence.*
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
    @ElementCollection(fetch = FetchType.EAGER)
    val roles: MutableSet<Role> = mutableSetOf()
)
