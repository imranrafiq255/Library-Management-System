package com.example.imran.Library.Management.System.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class AdminDto {
    private Long id;
    @NotBlank(message = "Admin Name is required")
    private String adminName;
    @NotBlank(message = "Admin Phone Number is required")
    private String adminPhoneNumber;
}
