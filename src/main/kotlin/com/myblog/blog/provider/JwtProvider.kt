package com.myblog.blog.provider

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.Date


@Component
class JwtProvider {

    private val secretKey: String = "S3cr3tk3y"

    fun create(email: String): String {
        val expiredDate: Date = Date.from(Instant.now().plus(1, ChronoUnit.HOURS))

        val jwt = Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .setSubject(email).setIssuedAt(Date()).setExpiration(expiredDate)
            .compact()

        return jwt
    }

    fun validate(jwt: String): String? {
        var claims: Claims
        try {
            claims = Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJwt(jwt).body
        } catch (exception: Exception) {
            exception.printStackTrace()
            return null
        }
        return claims.subject
    }
}