package services;

import dto.CreateOrUpdatePermission;
import dto.CreateOrUpdateRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import persistences.entities.Permission;
import persistences.entities.Role;

import java.util.Optional;

public interface PermissionService {

    Page<Permission> getPermissions(Pageable pageable);

    Permission store(CreateOrUpdatePermission createOrUpdatePermission);

    Permission update(Long id, CreateOrUpdatePermission createOrUpdatePermission);

    Optional<Permission> show(Long id);
}
