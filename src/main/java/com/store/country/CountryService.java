package com.store.country;

import java.util.Optional;

public interface CountryService {

    Optional<Country> getByName(String username);

    double exchange(double price);
}
