package com.api.springbootbaseapi.services.Permission;

import com.api.springbootbaseapi.dto.CreateOrUpdatePermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.api.springbootbaseapi.models.Permission;

import java.util.Optional;


public interface PermissionService {

    Page<Permission> getPermissions(Pageable pageable);

    Permission store(CreateOrUpdatePermission createOrUpdatePermission);

    Permission update(Long id, CreateOrUpdatePermission createOrUpdatePermission);

    Optional<Permission> show(Long id);
}
