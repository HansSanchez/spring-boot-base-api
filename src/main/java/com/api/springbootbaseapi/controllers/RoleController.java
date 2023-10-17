package com.api.springbootbaseapi.controllers;

import com.api.springbootbaseapi.dto.CreateOrUpdateRole;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.springbootbaseapi.models.TBRole;
import com.api.springbootbaseapi.services.RoleService;

import java.util.Optional;


@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Método para traer todos los roles
    @GetMapping("/getRoles")
    public ResponseEntity<Page<TBRole>> getRoles(Pageable pageable){
        Page<TBRole> rolePage = roleService.getRoles(pageable);
        if(rolePage.hasContent()){
            return ResponseEntity.ok(rolePage); // 200
        }
        return ResponseEntity.notFound().build();
    }

    // Método para la creación de un rol
    @PostMapping("/store")
    public ResponseEntity<TBRole> store(@RequestBody @Valid CreateOrUpdateRole createOrUpdateRole){
        TBRole TBRole = roleService.store(createOrUpdateRole);
        return ResponseEntity.status(HttpStatus.CREATED).body(TBRole);
    }

    // Método para la actualización de un rol
    @PutMapping("/update/{id}")
    public ResponseEntity<TBRole> update(@PathVariable Long id,
                                         @RequestBody @Valid CreateOrUpdateRole createOrUpdateRole){
        TBRole TBRole = roleService.update(id, createOrUpdateRole);
        return ResponseEntity.ok(TBRole);
    }

    // Método para traer un rol en especifico
    @GetMapping("/show/{id}")
    public ResponseEntity<TBRole> show(@PathVariable Long id){
        Optional<TBRole> role = roleService.show(id);
        if(role.isPresent()){
            return ResponseEntity.ok(role.get()); // 200
        }
        return ResponseEntity.notFound().build();
    }

}
