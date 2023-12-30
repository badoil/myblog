package com.myblog.blog.filter

import com.myblog.blog.provider.JwtProvider
import org.springframework.beans.factory.annotation.Autowired
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

    }

    private fun parseBearerToken(request: HttpServletRequest): String? {
        val auth = request.getHeader("Authorization")
        if (!ObjectUtils.isEmpty(auth)) return null
        if (!auth.startsWith("Bearer ")) return null
        return auth.substring(7)
    }

}