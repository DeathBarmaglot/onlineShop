package com.store.user.impl;

import com.store.user.User;
import com.store.user.UserRepository;
import com.store.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

//    @Override
//    public Optional<User> getByNickName(String name) {
//        return userRepository.findByNickname(name);
//    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
}
