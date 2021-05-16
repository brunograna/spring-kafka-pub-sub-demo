package com.demo.kafkapubsub.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Location {

    BRAZIL(2),
    US(1),
    INTERNATIONAL(0);

    private Integer identifier;

    Location(Integer identifier) {
        this.identifier = identifier;
    }

    @JsonValue
    public Integer getIdentifier() {
        return identifier;
    }


    @Override
    public String toString() {
        return "Location{" +
                "description='" + identifier + '\'' +
                '}';
    }
}
