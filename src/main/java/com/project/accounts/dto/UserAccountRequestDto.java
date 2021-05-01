package com.project.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountRequestDto {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 150, min = 3)
    private String name;

    @NotBlank(message = "Phone is mandatory")
    @Size(max = 12, min = 9)
    @Pattern(regexp = "^[0-9]+$", flags = Pattern.Flag.UNICODE_CASE, message = "Phone is not valid.")
    private String phone;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not valid")
    @Size(max = 200, min = 1)
    private String email;

    @Size(max = 200, min = 0)
    private String address;

    @NotBlank(message = "Country is mandatory")
    @Size(max = 56, min = 1)
    private String country;

    @NotBlank(message = "Department is mandatory")
    @Size(max = 50, min = 1)
    private String department;
}
