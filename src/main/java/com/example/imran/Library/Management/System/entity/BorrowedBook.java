package com.example.imran.Library.Management.System.entity;

import com.example.imran.Library.Management.System.enums.BookStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrowed_books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Member member;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime issuedDate;

    @Column(nullable = false)
    private LocalDate returningDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus bookStatus;
}
