package com.example.api.foo.infra.web.rest.controller;

import com.example.api.foo.domain.model.Foo;
import com.example.api.foo.domain.service.FooService;
import com.example.api.foo.domain.service.FooServiceImpl;
import com.example.api.foo.infra.web.rest.dto.response.FooResponse;
import com.example.api.util.Paths;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value =  Paths.FOO_VALUE)
@Tag(name = "Foo")
public class FooController {

    private final FooService fooService;


    @GetMapping("/{id}")
    public ResponseEntity<FooResponse> get(@PathVariable("id") Long id) {
        Foo foo = fooService.findOne(id);
        FooResponse fooResponse = FooResponse.builder().id(foo.getId()).env(foo.getEnv()).created(foo.getCreated()).build();
        return ResponseEntity.ok(fooResponse);
    }

    @GetMapping
    public ResponseEntity<List<FooResponse>> get() {
        var foos = fooService.listAll().stream().map(foo1 -> FooResponse.builder().id(foo1.getId()).env(foo1.getEnv()).created(foo1.getCreated()).build()).collect(Collectors.toList());
        return ResponseEntity.ok(foos);
    }

}