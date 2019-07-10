package com.example.api.unity.service;

import com.example.api.repository.FooRepository;
import com.example.api.service.FooService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.InvalidParameterException;

@RunWith(SpringRunner.class)
public class FooServiceTest {

    @InjectMocks
    private FooService fooService;

    @Mock
    private FooRepository fooRepository;

    @Test(expected = InvalidParameterException.class)
    public void whenParameterIdIsNull() {
        fooService.find(null);
    }

    @Test(expected = InvalidParameterException.class)
    public void whenParameterFooIsNull() {
        fooService.save(null);
    }

    @Test
    public void whenFindAllElements() {
    }

}
