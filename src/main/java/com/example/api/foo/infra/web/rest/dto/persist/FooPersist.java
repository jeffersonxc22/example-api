package com.example.api.foo.infra.web.rest.dto.persist;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FooPersist {

    @NotNull
    private String env;

    @NotNull
    private Integer quantity;

}
