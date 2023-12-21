package com.mete.security.service

import com.mete.security.dto.TreatmentAdvertisementRequest
import com.mete.security.entity.Address
import com.mete.security.entity.TreatmentAdvertisement
import com.mete.security.entity.User
import com.mete.security.repository.AddressRepository
import com.mete.security.repository.TreatmentAdvertisementRepository
import com.mete.security.repository.UserRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class TreatmentAdvertisementService(
    private val treatmentAdvertisementRepository: TreatmentAdvertisementRepository,
    private val userRepository: UserRepository,
    private val addressRepository: AddressRepository
) {
    fun getAllTreatmentAdvertisements(): List<TreatmentAdvertisement> {
        return treatmentAdvertisementRepository.findAll()
    }

    fun getTreatmentAdvertisementById(id: UUID): TreatmentAdvertisement? {
        return treatmentAdvertisementRepository.findByIdOrNull(id)
    }

    fun saveTreatmentAdvertisement(request: TreatmentAdvertisementRequest): TreatmentAdvertisement {
        val user: User = userRepository.findByIdOrNull(request.userId) ?: throw NotFoundException()
        val address: Address =
            addressRepository.findByIdOrNull(request.addressId) ?: throw NotFoundException()
        val treatmentAdvertisement = TreatmentAdvertisement(
            publisher = user,
            address = address,
            title = request.title,
            description = request.description
        )
        return treatmentAdvertisementRepository.save(treatmentAdvertisement)
    }
}