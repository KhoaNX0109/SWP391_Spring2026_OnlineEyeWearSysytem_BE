package com.eyewear.backend.config;

import com.eyewear.backend.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String token;
        final String username;

        // Ensure header starts with "Bearer " (or handle case where it doesn't if
        // OpenApiConfig says so,
        // strictly speaking standard is Bearer, but OpenApiConfig text said "without
        // 'Bearer ' prefix")
        // However, standard Spring Security usage usually implies Bearer.
        // Let's support both or stick to standard.
        // The user's swagger config said: "Enter JWT token (without 'Bearer ' prefix)"
        // but the Scheme is "bearer".
        // So Swagger UI will prepend "Bearer ".
        // Meaning I should expect "Bearer " in the header.

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        token = authHeader.substring(7);
        try {
            username = jwtUtil.extractUsername(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                if (jwtUtil.validateToken(token, username)) {
                    // Since we don't have a UserDetailsService yet, we just create a token with
                    // empty authorities
                    // Identify is verified by the token signature.
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            new ArrayList<>() // Authorities
                    );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        } catch (Exception e) {
            // Token invalid or expired
            // System.out.println("JWT Verification failed: " + e.getMessage());
        }

        filterChain.doFilter(request, response);
    }
}
