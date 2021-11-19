package com.example.api.foo.infra.web.rest.dto.update;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FooUpdate {

    @NotNull
    private String env;

    @NotNull
    private Integer quantity;

}
