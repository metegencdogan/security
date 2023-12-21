package com.mete.security.mapper

import com.mete.security.dto.TreatmentAdvertisementResponse
import com.mete.security.entity.TreatmentAdvertisement

fun TreatmentAdvertisement.toResponse() = TreatmentAdvertisementResponse(
    username = publisher.username,
    title = title,
    description = description,
    address = address
)