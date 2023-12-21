package com.mete.security.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "treatment_advertisement")
data class TreatmentAdvertisement(
    @Id val id: UUID = UUID.randomUUID(),
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val publisher: User,
    val title: String,
    val description: String,
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    val address: Address
)
