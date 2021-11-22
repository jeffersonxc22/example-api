package com.example.api.foo.domain.service;

import com.example.api.foo.domain.adapter.FooRepositoryAdapter;
import com.example.api.foo.domain.model.Foo;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class FooServiceImpl implements FooService {

    private final FooRepositoryAdapter fooRepositoryAdapter;

    @Transactional
    public Foo findOne (Long id) {
        return fooRepositoryAdapter.findOne(id);
    }

    public List<Foo> listAll() {
        return fooRepositoryAdapter.listAll();
    }

}
