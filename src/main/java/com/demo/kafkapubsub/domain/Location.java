package com.demo.kafkapubsub.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Location {

    BRAZIL("brazil", 2),
    US("us", 1),
    INTERNATIONAL("international", 0);

    private String name;
    private Integer identifier;

    Location(String name, Integer identifier) {
        this.name = name;
        this.identifier = identifier;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static Location fromName(String name) {
        if (name == null || name.isBlank()) return Location.INTERNATIONAL;
        for (Location location : Location.values()) {
            if (location.getName().equalsIgnoreCase(name)) {
                return location;
            }
        }
        throw new IllegalArgumentException(name + " is not valid");
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", identifier=" + identifier +
                '}';
    }
}
