package com.project.charity.mapper;

import com.project.charity.domain.AbstractEntity;
import com.project.charity.dto.AbstractDto;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);

    Stream<E> toEntities(Collection<D> dtos);

    List<E> toEntityList(Collection<D> dtos);

    Set<E> toEntitySet(Collection<D> dtos);

    Stream<D> toDtos(Collection<E> entities);

    List<D> toDtoList(Collection<E> entities);

    Set<D> toDtoSet(Collection<E> entities);

}
