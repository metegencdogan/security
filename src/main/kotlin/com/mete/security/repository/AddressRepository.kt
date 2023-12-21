package com.mete.security.repository

import com.mete.security.entity.Address
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AddressRepository : JpaRepository<Address, UUID>
