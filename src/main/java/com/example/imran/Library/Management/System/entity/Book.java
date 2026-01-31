package com.example.imran.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String bookTitle;
    @Column(nullable = false, length = 50)
    private String authorName;
    @Column(nullable = false, length = 30)
    private String bookCategory;
    @Column(nullable = false, unique = true)
    private String isbnNumber;
    @Column(nullable = false)
    private Integer numberOfCopies;
}
