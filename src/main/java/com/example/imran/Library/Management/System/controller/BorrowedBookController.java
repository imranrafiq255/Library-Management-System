package com.example.imran.Library.Management.System.controller;

import com.example.imran.Library.Management.System.dto.BorrowedBookDto;
import com.example.imran.Library.Management.System.entity.BorrowedBook;
import com.example.imran.Library.Management.System.service.BorrowedBookService;
import com.example.imran.Library.Management.System.util.ApiResponse;
import jakarta.validation.Valid;
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
    @PostMapping("/issue-book")
    public ResponseEntity<Map<String, String>> issueBook(@Valid @RequestBody BorrowedBookDto borrowedBookDto){
        borrowedBookService.issueBook(borrowedBookDto);
        return ResponseEntity.ok(ApiResponse.apiResponse("Book is issued successfully"));
    }
    @GetMapping("/view-issued-books")
    public ResponseEntity<List<BorrowedBook>> viewIssuedBooks(){
        return ResponseEntity.ok(borrowedBookService.viewIssuedBooks());
    }
}
