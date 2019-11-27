package com.example.api.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
public class FooRequest extends GenericRequest {

    private String env;

    private Integer quantity;

    private Double value;
}
