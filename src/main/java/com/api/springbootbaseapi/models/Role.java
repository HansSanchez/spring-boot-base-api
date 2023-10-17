package com.api.springbootbaseapi.models;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tb_roles")
public class Role {

    // Llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del Rol para el sistema
    @Column(name = "name", nullable = false)
    private String name;

    // Nombre del Rol para el usuario
    @Column(name = "display_name", nullable = false)
    private String display_name;

    // Fecha de creación
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private Timestamp created_at;

    // Fecha de actualización
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    private Timestamp updated_at;

    @ManyToMany
    @JoinTable(
            name = "tb_role_permission",
            joinColumns = @JoinColumn(name = "tb_role_id"),
            inverseJoinColumns = @JoinColumn(name = "tb_permission_id")
    )
    private List<Permission> tb_permissions;

    // Relación con los roles
    @ManyToMany
    @JoinTable(
            name = "tb_user_role",
            joinColumns = @JoinColumn(name = "tb_role_id"),
            inverseJoinColumns = @JoinColumn(name = "tb_user_id")
    )
    private List<User> tb_users;

    // Guardado automático de la fecha de creación
    @PrePersist
    protected void onCreate() {
        created_at = new Timestamp((new Date()).getTime());
    }

    // Guardado automático de la fecha de autoalización
    @PreUpdate
    protected void onUpdate() {
        updated_at = new Timestamp((new Date()).getTime());
    }

}
