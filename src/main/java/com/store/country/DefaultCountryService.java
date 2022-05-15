package com.store.country;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultCountryService implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public Optional<Country> getByName(String username) {
        return countryRepository.findByCountryName(username);
    }

    @Override
    public double exchange(double price) {
        return 0;
    }
}
