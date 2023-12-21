package com.mete.security.controller

import com.mete.security.dto.RegistrationRequest
import com.mete.security.dto.Role
import com.mete.security.entity.User
import com.mete.security.service.CustomUserDetailsService
import com.mete.security.service.TokenService
import jakarta.annotation.security.RolesAllowed
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/security")
@CrossOrigin("*")
class SecurityController(
    private val tokenService: TokenService,
    private val customUserDetailsService: CustomUserDetailsService
) {

    @PostMapping("/register")
    fun registerUser(@RequestBody registrationRequest: RegistrationRequest): ResponseEntity<String> {
        customUserDetailsService.registerUser(registrationRequest)
        return ResponseEntity.ok("User registered successfully")
    }

    @PostMapping("/login")
    fun getHello(authentication: Authentication): ResponseEntity<String> {
        val token = tokenService.generateToken(authentication)
        return ResponseEntity.ok(token)
    }

    @GetMapping("/admin")
    @RolesAllowed(value = ["ADMIN"])
    fun getHelloAdmin(): ResponseEntity<String> {
        return ResponseEntity.ok("Hello")
    }

    @PostMapping("/user/{username}/assign-roles")
    @RolesAllowed(value = ["ADMIN"])
    fun assignRolesToUser(@PathVariable username: String, @RequestBody roles: List<Role>): User? {
        return customUserDetailsService.assignRolesToUser(username, roles)
    }
}