package com.store.security;

import lombok.RequiredArgsConstructor;

import java.security.MessageDigest;

@RequiredArgsConstructor
public class PasswordEncoder {

    private final MessageDigest digester;

    public PasswordEncoder(){
        try {
            String SHA_256 = "SHA_256";
            digester = MessageDigest.getInstance(SHA_256);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    public String getHashedPassword(String password) {
        return new String(digester.digest(password.getBytes()));
    }

    public boolean matches(String dbPassword, String password){
        String hashedPassword = getHashedPassword(password);
        return dbPassword.equals(hashedPassword);
    }
}
