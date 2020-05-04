package com.example.api.util;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class Converter {

    private final ModelMapperFactory modelMapperFactory;

    public <S, D> void map(S source, D destiny) {
        map(source,destiny, modelMapperFactory.modelMapperMatchingStrategyStrict());
    }

    public <S, D> D map(S source, Class<D> destinationType) {
        return  map(source,destinationType, modelMapperFactory.modelMapperMatchingStrategyStrict());
    }

    public <S, D> List<D> mapAll(Collection<S> sources, Class<D> destinationType) {
        return  mapAll(sources, destinationType, modelMapperFactory.modelMapperMatchingStrategyStrict());
    }

    public <S, D> void mapWithoutNull(S source, D destiny) {
        map(source,destiny, modelMapperFactory.modelMapperMatchingStrategyStrictAndNotNull());
    }


    private <S, D> void map(S source, D destiny, ModelMapper modelMapper) {
        modelMapper.map(source, destiny);
    }

    private <S, D> D map(S source, Class<D> destinationType, ModelMapper modelMapper) {
        return modelMapper.map(source, destinationType);
    }


    private <S, D> List<D> mapAll(Collection<S> sources, Class<D> destinationType, ModelMapper modelMapper) {
        return  sources.parallelStream().map( element -> modelMapper.map(element, destinationType)).collect(Collectors.toList());
    }





}

