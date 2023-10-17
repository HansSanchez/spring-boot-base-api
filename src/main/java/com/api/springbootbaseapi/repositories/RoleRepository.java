package com.api.springbootbaseapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.springbootbaseapi.models.TBRole;

public interface RoleRepository extends JpaRepository<TBRole, Long> {
}
