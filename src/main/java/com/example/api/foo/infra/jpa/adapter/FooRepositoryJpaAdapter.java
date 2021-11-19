package com.example.api.foo.infra.jpa.adapter;

import com.example.api.foo.domain.adapter.FooRepositoryAdapter;
import com.example.api.foo.domain.model.Foo;
import com.example.api.foo.infra.jpa.entity.FooEntity;
import com.example.api.foo.infra.jpa.repository.FooRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FooRepositoryJpaAdapter implements FooRepositoryAdapter {

    private final FooRepository fooRepository;

    @Override
    public Foo findOne(Long id) {

        FooEntity fooEntity = fooRepository.getOne(id);
        return Foo
                .builder()
                .id(fooEntity.getId())
                .quantity(fooEntity.getQuantity())
                .env(fooEntity.getEnv())
                .created(fooEntity.getCreated())
                .build();

    }

    @Override
    public List<Foo> listAll() {
         return  fooRepository.findAll().stream().map(fooEntity ->
                 Foo
                         .builder()
                         .id(fooEntity.getId())
                         .quantity(fooEntity.getQuantity())
                         .env(fooEntity.getEnv())
                         .created(fooEntity.getCreated()).build())

                 .collect(Collectors.toList());
    }
}
