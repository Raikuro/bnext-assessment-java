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
public class GetCommonContactsDto {
    @NotNull
    private String userId1;
    @NotNull
    private String userId2;
}
