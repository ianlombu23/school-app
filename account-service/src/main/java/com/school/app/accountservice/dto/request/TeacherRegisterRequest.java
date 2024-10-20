package com.school.app.accountservice.dto.request;

import com.school.app.accountservice.validation.PhoneNumberValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class TeacherRegisterRequest {
    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String email;

    @NotNull(message = "Phone Number can not blank")
    @PhoneNumberValid
    private String phoneNumber;

    private String address;
}
