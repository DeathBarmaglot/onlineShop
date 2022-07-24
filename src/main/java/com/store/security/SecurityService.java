package com.store.security;

import com.store.role.Role;
import com.store.user.User;
import com.store.user.UserDto;

import java.util.List;
import java.util.Optional;

public interface SecurityService {

    boolean isExpired(Token token);

    boolean isGranted(Token token, String resource);

    Optional<Token> getToken(String username, String password);

    Token addToStorageToken(User user);

    User saveUser(User user);

    Role saveRole(Role role);

    List<User> getUsers();
}