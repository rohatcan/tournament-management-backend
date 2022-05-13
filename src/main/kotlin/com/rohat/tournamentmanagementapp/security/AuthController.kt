package com.rohat.tournamentmanagementapp.security

import com.rohat.tournamentmanagementapp.graphql.input.user.LoginInput
import com.rohat.tournamentmanagementapp.model.User
import com.rohat.tournamentmanagementapp.service.UserService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller


@Controller
class AuthController(

    private val authenticationManager: AuthenticationManager,
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider

) : GraphQLQueryResolver {

    @PreAuthorize("isAnonymous()")
    fun login(request: LoginInput): String? {

        val authToken = UsernamePasswordAuthenticationToken(request.userName, request.password)
        val auth: Authentication = authenticationManager.authenticate(authToken)
        SecurityContextHolder.getContext().authentication = auth
        val jwtToken: String = jwtTokenProvider.generateToken(auth)
        val user: User = userService.findUserByUserName(request.userName)
//        val authResponse = AuthResponse()
//        authResponse.setAccessToken("Bearer $jwtToken")
//        authResponse.setUserId(user.getId())
        return "Bearer $jwtToken"
    }


}
