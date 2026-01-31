package com.example.imran.Library.Management.System.repository;

import com.example.imran.Library.Management.System.entity.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
}
