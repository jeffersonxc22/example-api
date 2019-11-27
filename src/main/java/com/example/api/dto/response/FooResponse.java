package com.example.api.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
public class FooResponse {

    private String env;

    private Integer quantity;

    private Double value;
}
