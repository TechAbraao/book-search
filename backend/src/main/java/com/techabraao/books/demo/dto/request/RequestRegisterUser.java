package com.techabraao.books.demo.dto.request;

import com.techabraao.books.demo.constants.enums.UserRoles;
import com.techabraao.books.demo.dto.response.UsersDTO;
import com.techabraao.books.demo.models.UsersModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestRegisterUser(
        @NotBlank(message = "The username field is required")
        String username,

        @NotBlank(message = "The email field is required")
        @Email(message = "The email must be in a valid format (e.g. user@example.com)")
        String email,

        @NotBlank(message = "The password field is required")
        String password,

        @NotNull(message = "The role field is required")
        UserRoles role

) {
    public UsersModel toUser(String hashedPassword) {
        UsersModel user = new UsersModel();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setRole(role);

        return user;
    }
    public UsersDTO toUserDTO() {
        return new UsersDTO(username, email);
    }
}
