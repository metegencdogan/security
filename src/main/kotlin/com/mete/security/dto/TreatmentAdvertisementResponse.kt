package com.mete.security.dto

import com.mete.security.entity.Address

data class TreatmentAdvertisementResponse(
    val username: String,
    val title: String,
    val description: String,
    val address: Address
)
