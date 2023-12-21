package com.mete.security.controller

import com.mete.security.entity.Address
import com.mete.security.service.AddressService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/addresses")
class AddressController(
    private val addressService: AddressService
) {
    @GetMapping
    fun getAllAddresses(): List<Address> {
        return addressService.getAllAddresses()
    }

    @GetMapping("/{id}")
    fun getAddressById(@PathVariable id: UUID): Address? {
        return addressService.getAddressById(id)
    }

    @PostMapping
    fun saveAddress(@RequestBody address: Address): Address {
        return addressService.saveAddress(address)
    }
}