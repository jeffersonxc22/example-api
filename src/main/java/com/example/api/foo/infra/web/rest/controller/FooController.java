package com.example.api.foo.infra.web.rest.controller;

import com.example.api.foo.infra.web.rest.adapter.FooWebRestAdapter;
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

@AllArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value =  Paths.FOO_VALUE)
@Tag(name = "Foo")
public class FooController {

    private final FooWebRestAdapter fooWebAdapter;


    @GetMapping("/{id}")
    public ResponseEntity<FooResponse> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(fooWebAdapter.findOne(id));
    }

    @GetMapping
    public ResponseEntity<List<FooResponse>> get() {
        return ResponseEntity.ok(fooWebAdapter.listAll());
    }

}