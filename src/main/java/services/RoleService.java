package services;

import dto.CreateOrUpdateRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import persistences.entities.Role;

import java.util.Optional;

public interface RoleService {

    Page<Role> getRoles(Pageable pageable);

    Role store(CreateOrUpdateRole createOrUpdateRole);

    Role update(Long id, CreateOrUpdateRole createOrUpdateRole);

    Optional<Role> show(Long id);
}
