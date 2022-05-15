package com.store.user;

import java.util.Optional;

public interface UserService {

//    Optional<User> getByNickName(String name);

    Optional<User> getById(Long id);
}