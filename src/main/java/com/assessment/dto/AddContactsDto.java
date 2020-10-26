package com.assessment.dto;

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
public class AddContactsDto{
    @NotNull
    private String contactName;
    @NotNull
    private String phone;
}