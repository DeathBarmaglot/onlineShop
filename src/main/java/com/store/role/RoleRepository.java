package com.store.role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(@Nullable String name);

    Optional<Role> findByRoleId(@Nullable Long roleId);
}
