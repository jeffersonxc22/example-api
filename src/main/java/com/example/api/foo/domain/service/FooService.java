package com.example.api.foo.domain.service;

import com.example.api.foo.domain.model.Foo;

import java.util.List;

public interface FooService {

    Foo findOne(Long id);

    List<Foo> listAll();

}
