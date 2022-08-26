package com.example.webapp.model;

import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    private int id;
    private String role;

    public Role() {
    }

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return role;
    }

    public void setName(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
