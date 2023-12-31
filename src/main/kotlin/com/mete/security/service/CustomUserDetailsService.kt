package com.mete.security.service

import com.mete.security.dto.RegistrationRequest
import com.mete.security.dto.Role
import com.mete.security.entity.User
import com.mete.security.repository.UserRepository
import org.springframework.context.annotation.Lazy
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository,
    @Lazy private val passwordEncoder: PasswordEncoder
) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user: User = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found with username: $username")

        val roles: List<String> = user.roles.map { it.name }

        return org.springframework.security.core.userdetails.User.builder()
            .username(user.username)
            .password(user.password)
            .roles(*roles.toTypedArray())
            .build()
    }

    fun registerUser(registrationRequest: RegistrationRequest): User {
        val user = User(
            username = registrationRequest.username,
            password = passwordEncoder.encode(registrationRequest.password),
            email = registrationRequest.email,
            phoneNumber = registrationRequest.phoneNumber
        )

        return userRepository.save(user)
    }

    fun assignRolesToUser(username: String, roles: List<Role>): User? {
        return userRepository.findByUsername(username)?.let {
            it.roles.addAll(roles)
            userRepository.save(it)
        } ?: throw NotFoundException()
    }
}
