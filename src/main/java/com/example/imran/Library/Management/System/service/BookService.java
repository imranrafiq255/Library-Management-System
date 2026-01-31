package com.example.imran.Library.Management.System.service;

import com.example.imran.Library.Management.System.dto.BookDto;
import com.example.imran.Library.Management.System.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    void addBook(BookDto bookDto);
    void updateBook(Long id, BookDto bookDto);
    void deleteBook(Long id);
    List<Book> viewAllBooks();
    Book findBookById(Long id);
    Book findBookByBookTitle(String bookTitle);
}
