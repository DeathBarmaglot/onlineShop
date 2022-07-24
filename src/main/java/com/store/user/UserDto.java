package com.store.user;

import com.store.role.Role;
import com.store.security.Token;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String password;
    private Collection<Role> roles = new ArrayList<>();
    private Token token;
}
