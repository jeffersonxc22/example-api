package com.example.api.foo.domain.service;

import com.example.api.foo.domain.adapter.FooRepositoryAdapter;
import com.example.api.foo.domain.model.Foo;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class FooService {

    private final FooRepositoryAdapter fooRepositoryAdapter;

    public Foo findOne (Long id) {
        return fooRepositoryAdapter.findOne(id);
    }

    public List<Foo> listAll() {
        return fooRepositoryAdapter.listAll();
    }

}
