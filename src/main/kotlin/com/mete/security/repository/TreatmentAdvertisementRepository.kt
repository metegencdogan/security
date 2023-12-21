package com.mete.security.repository

import com.mete.security.entity.TreatmentAdvertisement
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TreatmentAdvertisementRepository : JpaRepository<TreatmentAdvertisement, UUID>