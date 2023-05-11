package dev.codextended.webservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @NotBlank(message = "User first name can't be blank or null")
    private String firstname;

    @NotBlank(message = "User last name can't be blank or null")
    private String lastname;

    @NotBlank(message = "User email can't be blank or null")
    @Email(message = "Must provide a valid email address")
    private String email;
}
