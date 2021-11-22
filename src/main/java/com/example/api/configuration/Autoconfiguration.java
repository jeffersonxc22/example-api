package com.example.api.configuration;

import com.example.api.foo.domain.adapter.FooRepositoryAdapter;
import com.example.api.foo.domain.service.FooServiceImpl;
import com.example.api.foo.infra.jpa.adapter.FooRepositoryJpaAdapter;
import com.example.api.foo.infra.jpa.repository.FooRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Autoconfiguration {


    @Bean
    FooServiceImpl fooService(FooRepositoryAdapter fooRepositoryAdapter) {
        return new FooServiceImpl(fooRepositoryAdapter);
    }


    @Bean
    FooRepositoryAdapter fooRepositoryAdapter(FooRepository fooRepository) {
        return new FooRepositoryJpaAdapter(fooRepository);
    }
}
