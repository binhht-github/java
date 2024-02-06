package com.example.demo2.until;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ModelMapperUntils {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public <T,D> D mapItem(T item,Class<D> cl){
        return modelMapper().map(item,cl);
    }
    public <T,D> List<D> mapList(List<T> list, Class<D> cl){
        return list.stream()
                .map(item -> modelMapper().map(item, cl))
                .collect(Collectors.toList());
    }
}
