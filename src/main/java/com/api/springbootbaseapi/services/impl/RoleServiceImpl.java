package com.api.springbootbaseapi.services.impl;

import com.api.springbootbaseapi.dto.CreateOrUpdateRole;
import com.api.springbootbaseapi.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.api.springbootbaseapi.models.TBRole;
import com.api.springbootbaseapi.repositories.RoleRepository;
import com.api.springbootbaseapi.services.RoleService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Page<TBRole> getRoles(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public TBRole store(CreateOrUpdateRole createOrUpdateRole) {
        // Instancia del objeto
        TBRole tbRole = new TBRole();
        tbRole.setName(createOrUpdateRole.getName()); // Guardado del nombre para el sistema
        tbRole.setDisplay_name(createOrUpdateRole.getDisplay_name()); // Guardado del nombre para el usuario
        tbRole.setCreated_at(new Timestamp((new Date()).getTime())); // Guardado de la fecha de creación
        return roleRepository.save(tbRole); // Guardado del rol
    }

    @Override
    public TBRole update(Long id, CreateOrUpdateRole createOrUpdateRole) {
        // Instancia del objeto
        TBRole TBRoleFromDB = roleRepository.findById(id)
                        .orElseThrow(() -> new ObjectNotFoundException("Rol no encontrado =>" + id));

        TBRoleFromDB.setName(createOrUpdateRole.getName()); // Guardado del nombre para el sistema
        TBRoleFromDB.setDisplay_name(createOrUpdateRole.getDisplay_name()); // Guardado del nombre para el usuario
        TBRoleFromDB.setUpdated_at(new Timestamp((new Date()).getTime())); // Guardado de la fecha de actualización
        return roleRepository.save(TBRoleFromDB); // actualización del rol
    }

    @Override
    public Optional<TBRole> show(Long id) {
        return roleRepository.findById(id);
    }
}
