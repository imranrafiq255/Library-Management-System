package com.example.imran.Library.Management.System.repository;

import com.example.imran.Library.Management.System.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByBookTitle(String bookTitle);
}
