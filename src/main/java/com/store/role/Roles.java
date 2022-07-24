package com.store.role;

import javax.persistence.Table;

@Table(name = "roles_enum")
public enum Roles {

    ADMIN("ADMIN"), USER("USER"), GUEST("GUEST");

    private final String name;

    Roles(String name) {
        this.name = name;
    }

    public String get() {
        return name;
    }
}

//implements Suspplier<String>