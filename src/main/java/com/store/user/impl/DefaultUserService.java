package com.store.user.impl;

import com.store.user.User;
import com.store.user.UserRepository;
import com.store.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class DefaultUserService implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUserDto = userRepository.findByUsername(username);
        if (optionalUserDto.isPresent()) {
            User user = optionalUserDto.get();
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
            log.info("{} user role added authorities to the database", username);
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        } else {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
    }

    @Override
    public Optional<User> getByUsername(String username) {
        log.info("Fetching user {} to the database", username);
        return userRepository.findByUsername(username);
    }
}
