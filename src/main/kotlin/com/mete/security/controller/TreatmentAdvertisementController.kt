package com.mete.security.controller

import com.mete.security.dto.TreatmentAdvertisementRequest
import com.mete.security.dto.TreatmentAdvertisementResponse
import com.mete.security.entity.TreatmentAdvertisement
import com.mete.security.mapper.toResponse
import com.mete.security.service.TreatmentAdvertisementService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/advertisements")
class TreatmentAdvertisementController(
    private val treatmentAdvertisementService: TreatmentAdvertisementService
) {
    @GetMapping
    fun getAllTreatmentAdvertisements(): List<TreatmentAdvertisementResponse> {
        return treatmentAdvertisementService.getAllTreatmentAdvertisements().map { it.toResponse() }
    }

    @GetMapping("/{id}")
    fun getTreatmentAdvertisementById(@PathVariable id: UUID): TreatmentAdvertisementResponse? {
        return treatmentAdvertisementService.getTreatmentAdvertisementById(id)?.toResponse()
    }

    @PostMapping
    fun saveTreatmentAdvertisement(@RequestBody treatmentAdvertisement: TreatmentAdvertisementRequest): TreatmentAdvertisement {
        return treatmentAdvertisementService.saveTreatmentAdvertisement(treatmentAdvertisement)
    }
}