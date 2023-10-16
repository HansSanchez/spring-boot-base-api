package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import models.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
