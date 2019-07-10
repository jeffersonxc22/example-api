package com.example.api.service;

import com.example.api.entity.Foo;
import com.example.api.repository.FooRepository;
import com.example.api.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

@Service
@AllArgsConstructor
public class FooService {

    private final FooRepository fooRepository;

    private final Converter converter;

    public List<Foo> findAll() {
        return fooRepository.findAll();
    }

    public Foo find(Long id) {
        Optional.ofNullable(id).orElseThrow(InvalidParameterException::new);
        return fooRepository.findById(id).orElseThrow(NoResultException::new);
    }


    public Foo save(Foo foo) {
        Optional.ofNullable(foo).orElseThrow(InvalidParameterException::new);
        return fooRepository.save(foo);
    }

    public boolean exists(Long id) {
        Optional.ofNullable(id).orElseThrow(InvalidParameterException::new);
        return fooRepository.existsById(id);
    }

    public Foo update(Foo update) {
        return update(update, converter::map);
    }

    public Foo partialUpdate(Foo update) {
        return update(update, converter::mapWithoutNull);
    }

    @Transactional
    private Foo update(Foo update, BiConsumer<Foo,Foo> consumer) {
        Optional.ofNullable(update).orElseThrow(InvalidParameterException::new);

        Foo foo = find(update.getId());

        consumer.accept(update, foo);

        return save(foo);
    }

    @Transactional
    public void delete(Long id) {
        Optional.ofNullable(id).orElseThrow(InvalidParameterException::new);
        fooRepository.deleteById(id);
    }
}
