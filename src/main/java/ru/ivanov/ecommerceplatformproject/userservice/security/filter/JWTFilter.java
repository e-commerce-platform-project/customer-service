package ru.ivanov.ecommerceplatformproject.userservice.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.ivanov.ecommerceplatformproject.userservice.security.JwtPrincipalDetails;
import ru.ivanov.ecommerceplatformproject.userservice.util.JWTUtils;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
//        String token = extractTokenFromAuthHeader(request);
//        if (token != null) {
//            try {
//                Authentication auth = authenticateToken(token);
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            } catch (JwtException e) {
//                handleAuthenticationError(response, "Invalid JWT token: " + e.getMessage());
//                return;
//            }
//        }
//
//        filterChain.doFilter(request, response);
    }
//
//    private String extractTokenFromAuthHeader(HttpServletRequest request) {
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            return authHeader.substring(7);
//        }
//        return null;
//    }
//
//    private void handleAuthenticationError(HttpServletResponse response, String message) throws IOException {
//        SecurityContextHolder.clearContext();
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setContentType("application/json");
//        response.getWriter().write("{\"error\":\"" + message + "\"}");
//    }
//
//    private Authentication authenticateToken(String token) {
//        if (jwtUtils.isServiceToken(token)) {
//            return handleServiceToken(token);
//        } else if (jwtUtils.isAccessToken(token)) {
//            return handleAccessToken(token);
//        }
//        throw new JwtException("Unsupported JWT type");
//    }
//
//    private Authentication handleServiceToken(String serviceToken) {
//        Claims claims = jwtUtils.validateAndParseServiceToken(serviceToken);
//        return createServiceAuthentication(claims);
//    }
//
//    private Authentication handleAccessToken(String accessToken) {
//        Claims claims = jwtUtils.validateAndParseAccessToken(accessToken);
//        return createUsernamePasswordAuthentication(claims);
//    }
//
//    @SuppressWarnings("unchecked")
//    private Authentication createServiceAuthentication(Claims claims) {
//        UUID subjectId = null;
//        Object subjectIdClaim = claims.get("subjectId");
//
//        if (subjectIdClaim != null) {
//            subjectId = UUID.fromString(subjectIdClaim.toString());
//        }
//
//        List<String> roles = claims.get("roles", List.class);
//        List<GrantedAuthority> authorities = roles.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//
//        JwtPrincipalDetails jwtPrincipalDetails = new JwtPrincipalDetails(subjectId, authorities);
//        return new UsernamePasswordAuthenticationToken(jwtPrincipalDetails, null, authorities);
//    }
//
//    @SuppressWarnings("unchecked")
//    private Authentication createUsernamePasswordAuthentication(Claims claims) {
//        UUID userId = UUID.fromString(claims.getSubject());
//
//        List<String> roles = claims.get("roles", List.class);
//        List<GrantedAuthority> authorities = roles.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//
//        JwtPrincipalDetails jwtPrincipalDetails = new JwtPrincipalDetails(userId, authorities);
//
//        return new UsernamePasswordAuthenticationToken(jwtPrincipalDetails, null, authorities);
//    }
}