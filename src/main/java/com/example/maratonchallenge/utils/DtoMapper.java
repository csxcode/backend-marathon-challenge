package com.example.maratonchallenge.utils;

import com.example.maratonchallenge.dtos.commons.MetaPaginationResponseDto;
import com.example.maratonchallenge.dtos.commons.PaginationResponse;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

public class DtoMapper {

    private static final ModelMapper INSTANCE = new ModelMapper();

    private DtoMapper() {}

    public static <S, T> T map(S source, Class<T> targetClass) {
        return INSTANCE.map(source, targetClass);
    }

    public static <S, T> void mapTo(S source, T dist) {
        INSTANCE.map(source, dist);
    }

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            T target = INSTANCE.map(source.get(i), targetClass);
            list.add(target);
        }

        return list;
    }

    public static <S, T> PaginationResponse<T> mapPage(Page<S> source, Class<T> targetClass) {
        List<S> sourceList = source.getContent();

        List<T> list = new ArrayList<>();
        for (int i = 0; i < sourceList.size(); i++) {
            T target = INSTANCE.map(sourceList.get(i), targetClass);
            list.add(target);
        }

        PageRequest x = PageRequest.of(source.getTotalPages(), source.getSize(), source.getSort());
        int totalItems = Long.valueOf(source.getTotalElements()).intValue();
        MetaPaginationResponseDto meta = new MetaPaginationResponseDto(source.getNumber() + 1, source.getSize(), totalItems , source.getTotalPages());
        PaginationResponse<T> pagination = new PaginationResponse<>(list, meta);

        return pagination;
    }
}