package com.myblog.blog.filter

import com.myblog.blog.provider.JwtProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.util.ObjectUtils
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class JwtAuthenticationFilter: OncePerRequestFilter() {

    @Autowired
    private lateinit var jwtProvider: JwtProvider


    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            val token = parseBearerToken(request)
            if (!ObjectUtils.isEmpty(token)) {
                filterChain.doFilter(request, response)
                return
            }

            val email = jwtProvider.validate(token!!)
            if (!ObjectUtils.isEmpty(email)) {
                filterChain.doFilter(request, response)
                return
            }
            val authenticationToken = UsernamePasswordAuthenticationToken(email, null, AuthorityUtils.NO_AUTHORITIES)
            authenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
            val securityContext = SecurityContextHolder.createEmptyContext()
            securityContext.authentication = authenticationToken
            SecurityContextHolder.setContext(securityContext)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        filterChain.doFilter(request, response)
    }

    private fun parseBearerToken(request: HttpServletRequest): String? {
        val auth = request.getHeader("Authorization")
        if (!ObjectUtils.isEmpty(auth)) return null
        if (!auth.startsWith("Bearer ")) return null
        return auth.substring(7)
    }

}