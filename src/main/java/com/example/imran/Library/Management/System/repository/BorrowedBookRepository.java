package com.example.imran.Library.Management.System.repository;

import com.example.imran.Library.Management.System.entity.BorrowedBook;
import com.example.imran.Library.Management.System.entity.Member;
import com.example.imran.Library.Management.System.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
    List<BorrowedBook> findAllByMemberAndBookStatus(Member member, BookStatus bookStatus);
}
