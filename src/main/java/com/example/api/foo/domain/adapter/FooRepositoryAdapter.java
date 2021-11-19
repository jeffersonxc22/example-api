package com.example.api.foo.domain.adapter;

import com.example.api.foo.domain.model.Foo;

import java.util.List;
import java.util.Set;

public interface FooRepositoryAdapter {

    Foo findOne(Long id);

    List<Foo> listAll();
}
