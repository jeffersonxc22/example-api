package com.example.api.foo.infra.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "FOO")
public class FooEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String env;

    private Integer quantity;

    private LocalDateTime created;

}