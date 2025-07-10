package com.techabraao.books.demo.dto.request;

import com.techabraao.books.demo.dto.response.UsersDTO;
import com.techabraao.books.demo.models.UsersModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RequestUsers(
        @NotBlank(message = "The username field is required")
        String username,

        @NotBlank(message = "The email field is required")
        @Email(message = "The email must be in a valid format (e.g. user@example.com)")
        String email,

        @NotBlank(message = "The password field is required")
        String password,

        @NotBlank(message = "The confirm password field is required")
        String confirmPassword
) {
    public UsersModel toUser() {
        UsersModel user = new UsersModel();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }
    public UsersDTO toUserDTO() {
        UsersDTO userDTO = new UsersDTO(username, email);

        return userDTO;
    }
}
