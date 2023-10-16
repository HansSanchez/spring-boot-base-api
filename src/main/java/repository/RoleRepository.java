package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
