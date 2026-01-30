package com.eyewear.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Login response with JWT token and user information")
public class LoginResponse {

    @Schema(description = "JWT access token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;

    @Schema(description = "Token type", example = "Bearer", defaultValue = "Bearer")
    private String tokenType = "Bearer";

    @Schema(description = "Customer ID", example = "1")
    private Integer customerId;

    @Schema(description = "Full name of the user", example = "John Doe")
    private String fullName;

    @Schema(description = "Email address", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Username", example = "johndoe")
    private String username;

    public LoginResponse(String token, Integer customerId, String fullName, String email, String username) {
        this.token = token;
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
    }
}