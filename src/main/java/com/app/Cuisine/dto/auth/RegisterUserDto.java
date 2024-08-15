package com.app.Cuisine.dto.auth;

import java.io.Serializable;

/**
 * DTO for {@link com.app.Cuisine.entity.User}
 */
public record RegisterUserDto(Integer id, String username, String email, String password) implements Serializable {
}