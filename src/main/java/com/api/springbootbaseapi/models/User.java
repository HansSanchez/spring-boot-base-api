package com.api.springbootbaseapi.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tb_users")
public class User {

    // Llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Primer nombre
    @Column(nullable = false)
    private String first_name;

    // Segundo nombre
    private String second_name;

    // Primer apellido
    @Column(nullable = false)
    private String last_name;

    // Segundo apellido
    private String second_surname;

    // Correo eléctrónico
    @Column(nullable = false)
    private String email;

    // Contraseña
    private String password;

    // Fecha de nacimiento
    private Date birthdate;

    // Número de telefono (fijo)
    private String phone_number;

    // Número de telefono (celular)
    private String cell_phone_number;

    // URL de la foto de perfil
    @Column(columnDefinition = "TEXT")
    private String profile_photo_path;

    // Estado
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    // Definición de estados para el usuario (puede cambiar según la regla de negocio)
    public static enum UserStatus {
        ACTIVE,           // ACTIVO
        INACTIVE,         // INACTIVO
        LOCKED,           // BLOQUEADO
        DELETED,          // ELIMINADO
        PENDING_APPROVAL  // PENDIENTE DE APROVACIÓN
    }

    // Fecha de creación
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private Timestamp created_at;

    // Fecha de actualización
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    private Timestamp updated_at;

    /*
     *   Relación de uno a muchos con "Acciones de seguimiento"
     *   ** Un usuario puede tener muchas acciones **
     */
    @OneToMany(mappedBy = "user")
    private List<TrackingAction> trackingActions = new ArrayList<>();

    /*
     *  Relación de muchos a muchos con "Roles"
     *  ** Muchos usuarios pueden tener muchos roles **
     */
    @ManyToMany(mappedBy = "tb_users")
    private List<Role> tb_roles;

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
