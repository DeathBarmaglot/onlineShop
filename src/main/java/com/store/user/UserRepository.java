package com.store.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

//    Optional<User> findByNickname(String username);

    Optional<User> findById(Long id);
}
