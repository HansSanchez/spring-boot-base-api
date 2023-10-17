package com.api.springbootbaseapi.dto;

import java.io.Serializable;

public class CreateOrUpdatePermission implements Serializable {
    // Nombre del Rol para el sistema
    private String key;
    // Nombre del Rol para el usuario
    private String table_name;
    // Fecha de creación


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }
}
