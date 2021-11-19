package com.example.api.foo.infra.jpa.repository;

import com.example.api.foo.infra.jpa.entity.FooEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository  extends JpaRepository<FooEntity, Long> {
}