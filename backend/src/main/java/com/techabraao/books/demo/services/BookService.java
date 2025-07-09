package com.techabraao.books.demo.services;

import com.techabraao.books.demo.dto.BookDTO;
import com.techabraao.books.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public long count() {
        return repository.count();
    }

    public List<BookDTO> listAllBooks() {
        return repository.findAll()
                .stream()
                .map(book -> new BookDTO(
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPublisher(),
                        book.getGender(),
                        book.getDescription()))
                .collect(Collectors.toList());
    }

    public void addBook(BookDTO book) {
        repository.save(book.toBook());
    };
}
