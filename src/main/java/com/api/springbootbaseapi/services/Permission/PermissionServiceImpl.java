package com.api.springbootbaseapi.services.Permission;

import com.api.springbootbaseapi.dto.CreateOrUpdatePermission;
import com.api.springbootbaseapi.exception.ObjectNotFoundException;
import com.api.springbootbaseapi.models.Permission;
import com.api.springbootbaseapi.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public Page<Permission> getPermissions(Pageable pageable) {
        return permissionRepository.findAll(pageable);
    }

    @Override
    public Permission store(CreateOrUpdatePermission createOrUpdatePermission) {
        Permission permission = new Permission();
        permission.setKey_name(createOrUpdatePermission.getKey()); // Guardado de la llave para el sistema
        permission.setTable_name(createOrUpdatePermission.getTable_name()); // Guardado de la tabla para el sistema
        permission.setCreated_at(new Timestamp((new Date()).getTime())); // Guardado de la fecha de creación
        return permissionRepository.save(permission); // Guardado del permiso
    }

    @Override
    public Permission update(Long id, CreateOrUpdatePermission createOrUpdatePermission) {
        // Instancia del objeto
        Permission permissionFromDB = permissionRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Permiso no encontrado =>" + id));

        permissionFromDB.setKey_name(createOrUpdatePermission.getKey()); // Guardado del nombre para el sistema
        permissionFromDB.setTable_name(createOrUpdatePermission.getTable_name()); // Guardado del nombre para el usuario
        permissionFromDB.setUpdated_at(new Timestamp((new Date()).getTime())); // Guardado de la fecha de actualización
        return permissionRepository.save(permissionFromDB); // Actualización del permiso
    }

    @Override
    public Optional<Permission> show(Long id) {
        return permissionRepository.findById(id);
    }
}
