package com.company.agora.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum EventPublishedValues implements EnumClass<Integer> {

    YES(10),
    NO(20);

    private Integer id;

    EventPublishedValues(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static EventPublishedValues fromId(Integer id) {
        for (EventPublishedValues at : EventPublishedValues.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}