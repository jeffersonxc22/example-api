package com.example.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class FooDTO {

    @NotNull
    private String env;

    @NotNull
    private Integer quantity;


    private Double value;
}
