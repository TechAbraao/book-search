package com.techabraao.books.demo.controllers;

import com.techabraao.books.demo.dto.ApiResponse;
import com.techabraao.books.demo.dto.BookDTO;
import com.techabraao.books.demo.dto.ResponseErrorList;
import com.techabraao.books.demo.services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    public final BookService service;

    @GetMapping
    public ResponseEntity<?> allBooks() {
        try {
            long total = service.count();
            List<BookDTO> allBooks = service.listAllBooks();

            ApiResponse<List<BookDTO>> response = new ApiResponse<>(
                    "Books fetched successfully.",
                    HttpStatus.OK.value(),
                    total,
                    allBooks
            );

            return ResponseEntity.ok(response);
        } catch (Exception error) {
            ResponseErrorList responseError = ResponseErrorList.badRequest(error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(responseError);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BookDTO>> addBook(@RequestBody @Valid BookDTO requestBook) {
        BookDTO book = new BookDTO(requestBook.title(), requestBook.author(), requestBook.publisher(),
                requestBook.gender(),
                requestBook.description()
        );

        service.addBook(book);

        ApiResponse<BookDTO> response = new ApiResponse<>(
                "Book created successfully.",
                HttpStatus.CREATED.value(),
                1,
                book
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
