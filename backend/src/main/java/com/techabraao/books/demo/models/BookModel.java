package com.techabraao.books.demo.models;

import com.techabraao.books.demo.constants.Genders;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "book",
        schema = "public"
)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true)
    private UUID id;

    @Column(name = "title", nullable = false, length = 30)
    private String title;

    @Column(name = "author", nullable = false, length = 50)
    private String author;

    @Column(name = "publisher", length = 30, nullable = false)
    private String publisher;

    @Column(name = "gender", nullable = false, length = 20)
    private Genders gender;

    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @CreatedDate
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = false)
    private LocalDateTime modifiedDate;
}
