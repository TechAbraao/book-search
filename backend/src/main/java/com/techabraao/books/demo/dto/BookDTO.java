package com.techabraao.books.demo.dto;

import com.techabraao.books.demo.constants.enums.Genders;
import com.techabraao.books.demo.models.BookModel;

public record BookDTO(
    String title,
    String author,
    String publisher,
    Genders gender,
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
