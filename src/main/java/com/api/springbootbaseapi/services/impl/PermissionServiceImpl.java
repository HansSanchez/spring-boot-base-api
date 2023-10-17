package com.api.springbootbaseapi.services.impl;

import com.api.springbootbaseapi.dto.CreateOrUpdatePermission;
import com.api.springbootbaseapi.exception.ObjectNotFoundException;
import com.api.springbootbaseapi.models.TBPermission;
import com.api.springbootbaseapi.repositories.PermissionRepository;
import com.api.springbootbaseapi.services.PermissionService;
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
    public Page<TBPermission> getPermissions(Pageable pageable) {
        return permissionRepository.findAll(pageable);
    }

    @Override
    public TBPermission store(CreateOrUpdatePermission createOrUpdatePermission) {
        TBPermission tbPermission = new TBPermission();
        tbPermission.setKey_name(createOrUpdatePermission.getKey()); // Guardado de la llave para el sistema
        tbPermission.setTable_name(createOrUpdatePermission.getTable_name()); // Guardado de la tabla para el sistema
        tbPermission.setCreated_at(new Timestamp((new Date()).getTime())); // Guardado de la fecha de creación
        return permissionRepository.save(tbPermission); // Guardado del permiso
    }

    @Override
    public TBPermission update(Long id, CreateOrUpdatePermission createOrUpdatePermission) {
        // Instancia del objeto
        TBPermission tbPermissionFromDB = permissionRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Permiso no encontrado =>" + id));

        tbPermissionFromDB.setKey_name(createOrUpdatePermission.getKey()); // Guardado del nombre para el sistema
        tbPermissionFromDB.setTable_name(createOrUpdatePermission.getTable_name()); // Guardado del nombre para el usuario
        tbPermissionFromDB.setUpdated_at(new Timestamp((new Date()).getTime())); // Guardado de la fecha de actualización
        return permissionRepository.save(tbPermissionFromDB); // Actualización del permiso
    }

    @Override
    public Optional<TBPermission> show(Long id) {
        return permissionRepository.findById(id);
    }
}
