package com.example.imran.Library.Management.System.service.serviceImpl;

import com.example.imran.Library.Management.System.dto.BorrowedBookDto;
import com.example.imran.Library.Management.System.entity.Book;
import com.example.imran.Library.Management.System.entity.BorrowedBook;
import com.example.imran.Library.Management.System.entity.Member;
import com.example.imran.Library.Management.System.enums.BookStatus;
import com.example.imran.Library.Management.System.exception.ResourceNotFoundException;
import com.example.imran.Library.Management.System.repository.BookRepository;
import com.example.imran.Library.Management.System.repository.BorrowedBookRepository;
import com.example.imran.Library.Management.System.repository.MemberRepository;
import com.example.imran.Library.Management.System.service.BorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedBookServiceImpl implements BorrowedBookService {
    @Autowired
    private BorrowedBookRepository borrowedBookRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;
    public void issueBook(BorrowedBookDto borrowedBookDto){
        Book book = bookRepository.findById(borrowedBookDto.getBookId()).orElseThrow(() -> new ResourceNotFoundException("Book id is invalid"));
        Member member = memberRepository.findById(borrowedBookDto.getMemberId()).orElseThrow(() -> new ResourceNotFoundException("Member id is invalid"));
        BorrowedBook borrowedBook = new BorrowedBook();
        borrowedBook.setBook(book);
        borrowedBook.setMember(member);
        borrowedBook.setBookStatus(BookStatus.ISSUED);
        borrowedBook.setReturningDate(borrowedBookDto.getReturningDate());
        borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public List<BorrowedBook> viewIssuedBooks() {
        return borrowedBookRepository.findAll();
    }
}
