package com.app.Cuisine.dto.auth;

import java.io.Serializable;

public record LoginUserDTO(String login, String password) implements Serializable {
}
