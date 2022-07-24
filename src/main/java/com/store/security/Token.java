package com.store.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
public class Token {

    private Long tokenId;
    private final LocalDateTime expiredTime;
    private final UUID uuid;

    public Token(long time) {
        this.uuid = UUID.randomUUID();
        this.expiredTime = LocalDateTime.now().plusSeconds(time);
        log.info("Get new token {} with expiredTime {}", uuid, expiredTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Token token = (Token) o;
        return tokenId != null && Objects.equals(tokenId, token.tokenId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}