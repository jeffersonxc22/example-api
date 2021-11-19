package com.example.api.foo.infra.web.rest.adapter;

import com.example.api.foo.infra.web.rest.dto.response.FooResponse;

import java.util.List;

public interface FooWebRestAdapter {

    FooResponse findOne(Long id);

    List<FooResponse> listAll();

}
