package com.ztw.cinema.repo;

import com.ztw.cinema.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {
    Optional<Role> findRoleByName(String name);
}
