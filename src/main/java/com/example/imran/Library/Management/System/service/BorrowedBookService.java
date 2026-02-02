package com.example.imran.Library.Management.System.service;

import com.example.imran.Library.Management.System.dto.BorrowedBookDto;
import com.example.imran.Library.Management.System.entity.BorrowedBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BorrowedBookService {
    void issueBook(BorrowedBookDto borrowedBookDto);
    List<BorrowedBook> viewIssuedBooks();
    List<BorrowedBook> viewAllIssuedBooksOfMember(Long memberId);
 }
