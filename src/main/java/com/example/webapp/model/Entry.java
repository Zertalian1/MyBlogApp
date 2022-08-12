package com.example.webapp.model;

import javax.persistence.*;

@Entity
@Table(name = "entries")
public class Entry {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;
    @Column(name = "content")
    private String text;

    public Entry(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Entry() {

    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }
}
