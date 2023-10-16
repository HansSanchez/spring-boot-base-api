package controller;

import dto.CreateOrUpdatePermission;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import models.Permission;
import services.PermissionService;


import java.util.Optional;


@RestController
@RequestMapping("permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    // Método para traer todos los permisos
    @GetMapping("/getPermissions")
    public ResponseEntity<Page<Permission>> getPermissions(Pageable pageable){
        Page<Permission> rolePage = permissionService.getPermissions(pageable);
        if(rolePage.hasContent()){
            return ResponseEntity.ok(rolePage); // 200
        }
        return ResponseEntity.notFound().build();
    }

    // Método para la creación de un permiso
    @PostMapping("/store")
    public ResponseEntity<Permission> store(@RequestBody @Valid CreateOrUpdatePermission createOrUpdatePermission){
        Permission role = permissionService.store(createOrUpdatePermission);
        return ResponseEntity.status(HttpStatus.CREATED).body(role);
    }

    // Método para la actualización de un permiso
    @PutMapping("/update/{id}")
    public ResponseEntity<Permission> update(@PathVariable Long id,
                                       @RequestBody @Valid CreateOrUpdatePermission createOrUpdatePermission){
        Permission role = permissionService.update(id, createOrUpdatePermission);
        return ResponseEntity.ok(role);
    }

    // Método para traer un permiso en especifico
    @GetMapping("/show/{id}")
    public ResponseEntity<Permission> show(@PathVariable Long id){
        Optional<Permission> role = permissionService.show(id);
        if(role.isPresent()){
            return ResponseEntity.ok(role.get()); // 200
        }
        return ResponseEntity.notFound().build();
    }

}
