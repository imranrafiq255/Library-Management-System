package com.example.imran.Library.Management.System.controller;

import com.example.imran.Library.Management.System.dto.BookDto;
import com.example.imran.Library.Management.System.entity.Book;
import com.example.imran.Library.Management.System.service.BookService;
import com.example.imran.Library.Management.System.util.ApiResponse;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/add-book")
    public ResponseEntity<Map<String, String>> addBook(@Valid @RequestBody BookDto bookDto){
        bookService.addBook(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.apiResponse("Book with title of " + bookDto.getBookTitle() + " successfully added to the database"));
    }
    @PutMapping("/update-book/{id}")
    public ResponseEntity<Map<String, String>> updateBook(@PathVariable Long id, @Valid @RequestBody BookDto bookDto){
        bookService.updateBook(id, bookDto);
        return ResponseEntity.ok(ApiResponse.apiResponse("Record is successfully updated for " + bookDto.getBookTitle()));
    }
    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<Map<String, String>> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok(ApiResponse.apiResponse("Book record deleted successfully"));
    }
    @GetMapping("/view-all-books")
    public ResponseEntity<List<Book>> viewAllBooks()
    {
        return ResponseEntity.ok(bookService.viewAllBooks());
    }
    @GetMapping("/find-book/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findBookById(id));
    }
    @GetMapping("/find-book-by-title/{bookTitle}")
    public ResponseEntity<Book> findBookByBookTitle(@PathVariable String bookTitle){
        return ResponseEntity.ok(bookService.findBookByBookTitle(bookTitle));
    }
}
