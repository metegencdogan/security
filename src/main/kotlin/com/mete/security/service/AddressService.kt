package com.mete.security.service

import com.mete.security.entity.Address
import com.mete.security.repository.AddressRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class AddressService(
    private val addressRepository: AddressRepository
) {
    fun getAllAddresses(): List<Address> {
        return addressRepository.findAll()
    }

    fun getAddressById(id: UUID): Address? {
        return addressRepository.findByIdOrNull(id)
    }

    fun saveAddress(address: Address): Address {
        return addressRepository.save(address)
    }
}