package com.assessment.dto;

import com.assessment.annotations.ValidPhone;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Introspected
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    @ValidPhone
    private String phone;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
}
