package com.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortDirection {

    DESC("desc"), ASC("asc");

    private final String value;

    public static SortDirection getDirection(String value) {
        for (SortDirection direction : SortDirection.values()) {
            if (direction.getValue().equalsIgnoreCase(value)) {
                return direction;
            }
        }
        throw new IllegalArgumentException("No direction ".concat(value));
    }
}