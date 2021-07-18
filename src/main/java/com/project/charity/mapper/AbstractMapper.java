package com.project.charity.mapper;

import com.project.charity.domain.AbstractEntity;
import com.project.charity.dto.AbstractDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;


public abstract class AbstractMapper<E extends AbstractEntity, D extends AbstractDto> implements Mapper<E, D> {

    @Autowired
    ModelMapper mapper;

    private Class<E> entityClass;
    private Class<D> dtoClass;

    public AbstractMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, entityClass);
    }

    @Override
    public D toDto(E entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, dtoClass);
    }

    @Override
    public Stream<E> toEntities(Collection<D> dtos) {
        return dtos
                .stream()
                .map(this::toEntity)
                .filter(Objects::nonNull);
    }

    @Override
    public List<E> toEntityList(Collection<D> dtos) {
        return toEntities(dtos)
                .collect(toList());
    }

    @Override
    public Set<E> toEntitySet(Collection<D> dtos) {
        return toEntities(dtos)
                .collect(toSet());
    }

    @Override
    public Stream<D> toDtos(Collection<E> entities) {
        return entities
                .stream()
                .map(this::toDto)
                .filter(Objects::nonNull);
    }

    @Override
    public List<D> toDtoList(Collection<E> entities) {
        return toDtos(entities).collect(toList());
    }

    @Override
    public Set<D> toDtoSet(Collection<E> entities) {
        return toDtos(entities).collect(toSet());
    }
}
