package com.api.springbootbaseapi.services;

import com.api.springbootbaseapi.dto.CreateOrUpdatePermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.api.springbootbaseapi.models.TBPermission;

import java.util.Optional;


public interface PermissionService {

    Page<TBPermission> getPermissions(Pageable pageable);

    TBPermission store(CreateOrUpdatePermission createOrUpdatePermission);

    TBPermission update(Long id, CreateOrUpdatePermission createOrUpdatePermission);

    Optional<TBPermission> show(Long id);
}
