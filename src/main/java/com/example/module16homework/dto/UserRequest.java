package com.example.module16homework.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank
    @Length(min = 2)
    private String firstName;

    @NotBlank
    @Length(min = 2)
    private String lastName;

    @Email(message = "Enter valid email")
    private String email;

    @Length(min = 6)
    private String password;
}
