package com.example.api.foo.infra.web.rest.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FooRequest extends GenericRequest {

    private String env;

    private Integer quantity;

}
