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
@Table(name = "tb_permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Llave primaria
    Long id;

    // Nombre del Rol para el sistema
    @Column(name = "key_name", nullable = false)
    String key_name;

    // Nombre del Rol para el usuario
    @Column(name = "table_name")
    String table_name;

    // Fecha de creación
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    Timestamp created_at;

    // Fecha de actualización
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    Timestamp updated_at;

    // Relación de muchos a muchos con roles
    @ManyToMany(mappedBy = "tb_permissions")
    List<Role> tb_roles;

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
