package com.example.imran.Library.Management.System.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class MemberDto {
    private Long id;
    @NotBlank(message = "Member name is required")
    private String memberName;
    @NotBlank(message = "Member contact number is required")
    @Pattern(regexp = "^0(3[0-9]{2})[0-9]{7}$", message = "Contact number should be valid Pakistani number")
    private String memberContactNumber;
    @NotBlank(message = "Member email is required")
    @Email(message = "Valid email is required")
    private String memberEmail;
    @NotBlank(message = "Membership id is required")
    private String membershipId;
}
