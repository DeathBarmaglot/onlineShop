package com.store.model.currency;

public enum Exchange {
    USD("USD"), EUR("EUR");
    private final String name;

    Exchange(String name) {
        this.name = name;
    }

    public String get() {
        return name;
    }
}