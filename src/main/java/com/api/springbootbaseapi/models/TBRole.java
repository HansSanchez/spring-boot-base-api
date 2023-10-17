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
public class TBRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Llave primaria
    Long id;

    // Nombre del Rol para el sistema
    @Column(name = "name", nullable = false)
    String name;

    // Nombre del Rol para el usuario
    @Column(name = "display_name", nullable = false)
    String display_name;

    // Fecha de creación
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    Timestamp created_at;

    // Fecha de actualización
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    Timestamp updated_at;

    @ManyToMany
    @JoinTable(
            name = "tb_role_permission",
            joinColumns = @JoinColumn(name = "tb_role_id"),
            inverseJoinColumns = @JoinColumn(name = "tb_permission_id")
    )
    List<TBPermission> tb_permissions;

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
