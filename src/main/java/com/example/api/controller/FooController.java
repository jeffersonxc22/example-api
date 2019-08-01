package com.example.api.controller;

import com.example.api.dto.FooDTO;
import com.example.api.dto.FooPartialUpdateDTO;
import com.example.api.dto.FooResponseDTO;
import com.example.api.dto.FooUpdateDTO;
import com.example.api.entity.Foo;
import com.example.api.service.FooService;
import com.example.api.util.Converter;
import com.example.api.util.Paths;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value =  Paths.FOO_VALUE)
public class FooController {

    private final FooService fooService;

    private final Converter converter;

    @GetMapping
    public ResponseEntity<List<FooResponseDTO>> get() {
        return ResponseEntity.ok(converter.mapAll(fooService.findAll(), FooResponseDTO.class));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FooResponseDTO> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(converter.map(fooService.find(id), FooResponseDTO.class));
    }

    @PostMapping
    public ResponseEntity<FooResponseDTO> post(@Valid @RequestBody FooDTO fooDTO) {
        return ResponseEntity.ok(converter.map(fooService.save(converter.map(fooDTO, Foo.class)), FooResponseDTO.class));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FooResponseDTO> put(@PathVariable("id") Long id, @Valid @RequestBody FooUpdateDTO fooUpdateDTO) {
        Foo foo = converter.map(fooUpdateDTO, Foo.class);
        foo.setId(id);
        return  ResponseEntity.ok(converter.map(fooService.update(foo), FooResponseDTO.class));
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FooResponseDTO> patch(@PathVariable("id") Long id, @Valid @RequestBody FooPartialUpdateDTO fooPartialUpdateDTO) {
        Foo foo = converter.map(fooPartialUpdateDTO, Foo.class);
        foo.setId(id);
        return  ResponseEntity.ok(converter.map(fooService.partialUpdate(foo), FooResponseDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        fooService.delete(id);
        return ResponseEntity.noContent().build();
    }


}