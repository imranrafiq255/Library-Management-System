package com.example.imran.Library.Management.System.service.serviceImpl;

import com.example.imran.Library.Management.System.dto.BookDto;
import com.example.imran.Library.Management.System.entity.Book;
import com.example.imran.Library.Management.System.exception.ResourceNotFoundException;
import com.example.imran.Library.Management.System.repository.BookRepository;
import com.example.imran.Library.Management.System.service.BookService;
import com.example.imran.Library.Management.System.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public void addBook(BookDto bookDto){
        Book book = new Book();
        book.setBookTitle(bookDto.getBookTitle());
        book.setBookCategory(bookDto.getBookCategory());
        book.setAuthorName(bookDto.getAuthorName());
        book.setIsbnNumber(bookDto.getIsbnNumber());
        book.setNumberOfCopies(bookDto.getNumberOfCopies());
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No record found with given id"));
        book.setBookTitle(bookDto.getBookTitle());
        book.setBookCategory(bookDto.getBookCategory());
        book.setAuthorName(bookDto.getAuthorName());
        book.setIsbnNumber(bookDto.getIsbnNumber());
        book.setNumberOfCopies(bookDto.getNumberOfCopies());
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No record found with given id"));
        bookRepository.delete(book);
     }

    @Override
    public List<Book> viewAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @Override
    public Book findBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No record found with given id"));
        return book;
    }

    @Override
    public Book findBookByBookTitle(String bookTitle) {
        Book book = bookRepository.findBookByBookTitle(bookTitle);
        if (book == null)
            throw new ResourceNotFoundException("No record found with given book title");
        return book;
    }
}
