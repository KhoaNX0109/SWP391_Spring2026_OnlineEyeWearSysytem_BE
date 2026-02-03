package com.eyewear.backend.service;

import com.eyewear.backend.dto.request.LoginRequest;
import com.eyewear.backend.dto.response.LoginResponse;
import com.eyewear.backend.entity.CustomerAccount;
import com.eyewear.backend.repository.CustomerAccountRepository;
import com.eyewear.backend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final CustomerAccountRepository customerAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public LoginResponse login(LoginRequest loginRequest) {
        // Find user by username
        CustomerAccount account = customerAccountRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        // Check if account is active
        if (!"ACTIVE".equalsIgnoreCase(account.getStatus())) {
            throw new RuntimeException("Account is not active");
        }

        // Check password
        // if (!passwordEncoder.matches(loginRequest.getPassword(),
        // account.getPasswordHash())) {
        // throw new RuntimeException("Invalid username or password");
        // }

        // Plain text check
        if (account.getPassword() == null || !account.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        // Create token
        String token = jwtUtil.generateToken(account.getUsername(), account.getCustomerId());

        // Return response
        return new LoginResponse(
                token,
                account.getCustomer().getCustomerId(),
                account.getCustomer().getFullName(),
                account.getCustomer().getEmail(),
                account.getUsername());
    }
}