package com.example.api.foo.infra.web.rest.dto.update;

import lombok.Data;

@Data
public class FooPartialUpdate {

    private String env;

    private Integer quantity;
}
