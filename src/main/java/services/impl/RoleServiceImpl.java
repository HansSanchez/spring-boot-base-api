package services.impl;

import dto.CreateOrUpdateRole;
import exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import models.Role;
import repository.RoleRepository;
import services.RoleService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Page<Role> getRoles(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Role store(CreateOrUpdateRole createOrUpdateRole) {
        // Instancia del objeto
        Role role = new Role();
        role.setName(createOrUpdateRole.getName()); // Guardado del nombre para el sistema
        role.setDisplay_name(createOrUpdateRole.getDisplay_name()); // Guardado del nombre para el usuario
        role.setCreated_at(new Timestamp((new Date()).getTime())); // Guardado de la fecha de creación
        return roleRepository.save(role); // Guardado del rol
    }

    @Override
    public Role update(Long id, CreateOrUpdateRole createOrUpdateRole) {
        // Instancia del objeto
        Role roleFromDB = roleRepository.findById(id)
                        .orElseThrow(() -> new ObjectNotFoundException("Rol no encontrado =>" + id));

        roleFromDB.setName(createOrUpdateRole.getName()); // Guardado del nombre para el sistema
        roleFromDB.setDisplay_name(createOrUpdateRole.getDisplay_name()); // Guardado del nombre para el usuario
        roleFromDB.setUpdated_at(new Timestamp((new Date()).getTime())); // Guardado de la fecha de actualización
        return roleRepository.save(roleFromDB); // Guardado del rol
    }

    @Override
    public Optional<Role> show(Long id) {
        return roleRepository.findById(id);
    }
}
