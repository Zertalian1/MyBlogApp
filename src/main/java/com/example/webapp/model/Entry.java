package com.example.webapp.model;

import javax.persistence.*;

@Entity
@Table(name = "entries")
public class Entry {
    @Id
    @SequenceGenerator(name = "entriesIdSeq", sequenceName = "entries_id_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "entriesIdSeq")
    private int id;

    @Column(name = "title")
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

    public void setId(int id) {
        this.id = id;
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
}
