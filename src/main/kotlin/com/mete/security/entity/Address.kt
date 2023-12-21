package com.mete.security.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "address")
data class Address(
    @Id val id: UUID = UUID.randomUUID(),
    val street: String,
    val houseNumber: String,
    val city: String,
    val country: String,
    val postcode: String
)
