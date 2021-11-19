package com.example.api.configuration;

import com.example.api.foo.domain.adapter.FooRepositoryAdapter;
import com.example.api.foo.domain.adapter.FooWebAdapter;
import com.example.api.foo.domain.service.FooService;
import com.example.api.foo.infra.jpa.adapter.FooRepositoryJpaAdapter;
import com.example.api.foo.infra.jpa.repository.FooRepository;
import com.example.api.foo.infra.web.rest.adapter.FooWebRestAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Autoconfiguration {


    @Bean
    FooService fooService(FooRepositoryAdapter fooRepositoryAdapter) {
        return new FooService(fooRepositoryAdapter);
    }

    @Bean
    FooWebRestAdapter fooWebRestAdapter(FooService fooService) {
        return new FooWebAdapter(fooService);
    }

    @Bean
    FooRepositoryAdapter fooRepositoryAdapter(FooRepository fooRepository) {
        return new FooRepositoryJpaAdapter(fooRepository);
    }
}
