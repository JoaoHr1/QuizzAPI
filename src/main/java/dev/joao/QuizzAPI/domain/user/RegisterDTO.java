package dev.joao.QuizzAPI.domain.user;

public record RegisterDTO(String login, String password, Roles role) {
}
