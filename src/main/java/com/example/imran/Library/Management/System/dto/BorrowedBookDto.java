package com.example.imran.Library.Management.System.dto;

import com.example.imran.Library.Management.System.enums.BookStatus;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class BorrowedBookDto {
    private Long id;
    @NotNull(message = "Book id is required")
    private Long bookId;
    @NotNull(message = "Book id is required")
    private Long memberId;
    @NotNull(message = "Returning date is required")
    private LocalDate returningDate;
    private BookStatus bookStatus;
}