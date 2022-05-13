package com.rohat.tournamentmanagementapp.security

import com.fasterxml.jackson.annotation.JsonIgnore
import com.rohat.tournamentmanagementapp.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import kotlin.collections.ArrayList

class UserPrincipal private constructor(

    val id: String?,
    @field:JsonIgnore
    val email: String?,
    private val username: String,
    @field:JsonIgnore
    private val password: String,
    private val authorities: Collection<GrantedAuthority>
) : UserDetails {

    override fun getUsername(): String {
        return username
    }

    override fun getPassword(): String {
        return password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authorities
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as UserPrincipal?
        return id == that!!.id
    }

    override fun hashCode(): Int {

        return Objects.hash(id)
    }

    companion object {

        fun create(user: User): UserPrincipal {
            return UserPrincipal(
                id = user.userId,
                username = user.username,
                email = user.email,
                authorities = ArrayList(),
                password = user.password,

                )
        }
    }
}