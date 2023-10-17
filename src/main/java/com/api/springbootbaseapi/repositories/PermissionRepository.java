package com.api.springbootbaseapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.springbootbaseapi.models.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
