package com.example.api.foo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Foo {

    private Long id;

    private String env;

    private Integer quantity;

    private LocalDateTime created;

}