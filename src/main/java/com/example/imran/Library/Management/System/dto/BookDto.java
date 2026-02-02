package com.example.imran.Library.Management.System.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookDto {
    private Long id;
    @NotBlank(message = "Book title is required")
    private String bookTitle;
    @NotBlank(message = "Book Author Name is required")
    private String authorName;
    @NotBlank(message = "Book Category is required")
    private String bookCategory;
    @NotBlank(message = "Book ISBN is required")
    private String isbnNumber;
    @NotNull(message = "No Of Copies is required")
    @Min(value = 1, message = "No Of Copies must be at least 1")
    private Integer numberOfCopies;
}
