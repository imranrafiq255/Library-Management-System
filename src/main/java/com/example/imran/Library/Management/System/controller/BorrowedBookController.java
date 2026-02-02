package com.example.imran.Library.Management.System.controller;

import com.example.imran.Library.Management.System.dto.BorrowedBookDto;
import com.example.imran.Library.Management.System.entity.Book;
import com.example.imran.Library.Management.System.entity.BorrowedBook;
import com.example.imran.Library.Management.System.exception.ResourceNotFoundException;
import com.example.imran.Library.Management.System.repository.BookRepository;
import com.example.imran.Library.Management.System.service.BorrowedBookService;
import com.example.imran.Library.Management.System.util.ApiResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/borrowed-book")
public class BorrowedBookController {
    @Autowired
    private BorrowedBookService borrowedBookService;
    @Autowired
    private BookRepository bookRepository;
    @PostMapping("/issue-book")
    public ResponseEntity<Map<String, String>> issueBook(@Valid @RequestBody BorrowedBookDto borrowedBookDto){
        Book book = bookRepository.findById(borrowedBookDto.getBookId()).orElseThrow(() -> new ResourceNotFoundException("Invalid book id"));
        if (book.getNumberOfCopies() <= 0)
            throw new ResourceNotFoundException("No copies available for " + book.getBookTitle());
        book.setNumberOfCopies(book.getNumberOfCopies() - 1);
        borrowedBookService.issueBook(borrowedBookDto);
        return ResponseEntity.ok(ApiResponse.apiResponse("Book is issued successfully"));
    }
    @GetMapping("/view-issued-books")
    public ResponseEntity<List<BorrowedBook>> viewIssuedBooks(){
        return ResponseEntity.ok(borrowedBookService.viewIssuedBooks());
    }
    @GetMapping("/view-all-issued-books-of-member/{memberId}")
    public ResponseEntity<List<BorrowedBook>> viewAllIssuedBooksOfMember(@PathVariable Long memberId){
        return ResponseEntity.ok(borrowedBookService.viewAllIssuedBooksOfMember(memberId));
    }
}
