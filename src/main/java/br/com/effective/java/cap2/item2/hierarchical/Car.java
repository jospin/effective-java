package br.com.effective.java.cap2.item2.hierarchical;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Car {
    public enum Type{SUV, HATCH, TURKEY, SEDAN}
    final Set<Type> types;
    private final String name;
    private final ObjectMapper mapper = new ObjectMapper();

    public Set<Type> getTypes() {
        return types;
    }

    public String getName() {
        return name;
    }

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Type> types = EnumSet.noneOf(Type.class);
        protected String name;

        public T addType(Type type) {
            types.add(Objects.requireNonNull(type));
            return self();
        }

        public T withName(String name) {
            this.name = name;
            return self();
        }

        abstract Car build();

        protected abstract T self();
    }

    public String toString() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    Car(Builder<?> builder) {
        types = builder.types.clone();
        this.name = builder.name;
    }
}
