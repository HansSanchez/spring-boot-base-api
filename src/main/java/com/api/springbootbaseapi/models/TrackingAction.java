package com.api.springbootbaseapi.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Table(name = "tb_tracking_actions")
public class TrackingAction {

    // Llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Acción que realizó
    @Column(nullable = false)
    private String action;

    // Módulo en la cual hizo una acción
    @Column(nullable = false)
    private String module;

    // Descripcción detallada de la acción o los cambios hechos
    @Column(columnDefinition = "TEXT")
    private String description;

    // Fecha de creación
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private Timestamp created_at;

    // Fecha de actualización
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    private Timestamp updated_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
