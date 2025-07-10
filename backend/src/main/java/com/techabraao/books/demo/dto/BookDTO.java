package com.techabraao.books.demo.dto;

import com.techabraao.books.demo.constants.enums.Genders;
import com.techabraao.books.demo.models.BookModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookDTO(
        @NotBlank(message = "The title field is required")
        String title,
        @NotBlank(message = "The author field is required")
        String author,
        @NotBlank(message = "The publisher field is required")
        String publisher,
        @NotNull(message = "The gender field is required")
        Genders gender,
        @NotBlank(message = "The description field is required")
        String description
) {
    public BookModel toBook() {
        BookModel book = new BookModel();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setGender(gender);
        book.setDescription(description);

        return book;
    }
}
