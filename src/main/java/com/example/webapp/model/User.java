package com.example.webapp.model;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "usersIdSeq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "usersIdSeq")
    private int id;

    private String username;

    private String nickname;

    private String password;
    @OneToMany
    private Set<Entry> entries;

    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(int id, String username, String password, Set<Entry> entries, Role role, String nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.entries = entries;
        this.role = role;
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Entry> getEntries() {
        return entries;
    }

    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
