package com.mete.security.dto

import java.util.UUID

data class TreatmentAdvertisementRequest(
    val userId: UUID,
    val title: String,
    val description: String,
    val addressId: UUID
)
