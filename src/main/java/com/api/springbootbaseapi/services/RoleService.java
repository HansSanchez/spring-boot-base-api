package com.api.springbootbaseapi.services;

import com.api.springbootbaseapi.dto.CreateOrUpdateRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.api.springbootbaseapi.models.TBRole;

import java.util.Optional;

public interface RoleService {

    Page<TBRole> getRoles(Pageable pageable);

    TBRole store(CreateOrUpdateRole createOrUpdateRole);

    TBRole update(Long id, CreateOrUpdateRole createOrUpdateRole);

    Optional<TBRole> show(Long id);
}
