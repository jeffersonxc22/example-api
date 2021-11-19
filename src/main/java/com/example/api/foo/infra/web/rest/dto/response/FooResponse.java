package com.example.api.foo.infra.web.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class FooResponse {

    private Long id;

    private String env;

    private Integer quantity;

    private LocalDateTime created;
}
