package dev.codextended.webservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Schema(
        description = "UserDto Model Information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    @Schema(description = "User First Name")
    @NotBlank(message = "User first name can't be blank or null")
    private String firstname;

    @Schema(description = "User Last Name")
    @NotBlank(message = "User last name can't be blank or null")
    private String lastname;

    @Schema(description = "User Email Address")
    @NotBlank(message = "User email can't be blank or null")
    @Email(message = "Must provide a valid email address")
    private String email;
}
