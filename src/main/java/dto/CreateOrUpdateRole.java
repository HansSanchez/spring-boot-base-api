package dto;

import java.io.Serializable;

public class CreateOrUpdateRole implements Serializable {
    // Nombre del Rol para el sistema
    private String name;
    // Nombre del Rol para el usuario
    private String display_name;
    // Fecha de creación


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
}
