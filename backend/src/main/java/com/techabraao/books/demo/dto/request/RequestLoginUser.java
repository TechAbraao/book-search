package com.techabraao.books.demo.dto.request;

import com.techabraao.books.demo.dto.response.UsersDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RequestLoginUser(

        @NotBlank(message = "The email field is required")
        @Email(message = "The email must be in a valid format (e.g. user@example.com)")
        String email,

        @NotBlank(message = "The password field is required")
        String password
) {
    public UsersDTO toUserDTO() {
        return new UsersDTO(email, password);
    }
}
