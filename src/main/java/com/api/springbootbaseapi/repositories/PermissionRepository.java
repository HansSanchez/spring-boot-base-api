package com.api.springbootbaseapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.springbootbaseapi.models.TBPermission;

public interface PermissionRepository extends JpaRepository<TBPermission, Long> {
}
