package com.api.springbootbaseapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.springbootbaseapi.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
