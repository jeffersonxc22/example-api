package com.example.api.dto.update;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class FooUpdate {

    @NotNull
    private String env;

    @NotNull
    private Integer quantity;

    @NotNull
    private Double value;
}
