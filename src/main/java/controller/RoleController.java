package controller;

import dto.CreateOrUpdateRole;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import models.Role;
import services.RoleService;

import java.util.Optional;


@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Método para traer todos los roles
    @GetMapping("/getRoles")
    public ResponseEntity<Page<Role>> getRoles(Pageable pageable){
        Page<Role> rolePage = roleService.getRoles(pageable);
        if(rolePage.hasContent()){
            return ResponseEntity.ok(rolePage); // 200
        }
        return ResponseEntity.notFound().build();
    }

    // Método para la creación de un rol
    @PostMapping("/store")
    public ResponseEntity<Role> store(@RequestBody @Valid CreateOrUpdateRole createOrUpdateRole){
        Role role = roleService.store(createOrUpdateRole);
        return ResponseEntity.status(HttpStatus.CREATED).body(role);
    }

    // Método para la actualización de un rol
    @PutMapping("/update/{id}")
    public ResponseEntity<Role> update(@PathVariable Long id,
                                       @RequestBody @Valid CreateOrUpdateRole createOrUpdateRole){
        Role role = roleService.update(id, createOrUpdateRole);
        return ResponseEntity.ok(role);
    }

    // Método para traer un rol en especifico
    @GetMapping("/show/{id}")
    public ResponseEntity<Role> show(@PathVariable Long id){
        Optional<Role> role = roleService.show(id);
        if(role.isPresent()){
            return ResponseEntity.ok(role.get()); // 200
        }
        return ResponseEntity.notFound().build();
    }

}
