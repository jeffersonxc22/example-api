package com.example.api.foo.domain.adapter;

import com.example.api.foo.domain.model.Foo;
import com.example.api.foo.domain.service.FooService;
import com.example.api.foo.infra.jpa.entity.FooEntity;
import com.example.api.foo.infra.jpa.repository.FooRepository;
import com.example.api.foo.infra.web.rest.adapter.FooWebRestAdapter;
import com.example.api.foo.infra.web.rest.dto.response.FooResponse;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FooWebAdapter implements FooWebRestAdapter {

    private final FooService fooService;

    @Override
    public FooResponse findOne(Long id) {

        Foo foo = fooService.findOne(id);
        return FooResponse
                .builder()
                .id(foo.getId())
                .quantity(foo.getQuantity())
                .env(foo.getEnv())
                .created(foo.getCreated())
                .build();

    }

    @Override
    public List<FooResponse> listAll() {
        return fooService.listAll().stream().map(foo ->
                FooResponse
                        .builder()
                        .id(foo.getId())
                        .quantity(foo.getQuantity())
                        .env(foo.getEnv())
                        .created(foo.getCreated())
                        .build()
                ).collect(Collectors.toList());
    }
}
