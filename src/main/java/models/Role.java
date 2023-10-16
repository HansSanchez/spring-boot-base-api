package models;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Llave primaria
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

    @ManyToMany
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id")
    )
    private List<Permission> permissions;
}
