package com.bur1y.best.fuckingdemo.database.table;

import javax.persistence.*;

@Entity
public class MaterialType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Title", nullable = false, length = 50)
    private String title;

    @Column(name = "DefectedPercent", nullable = false)
    private Double defectedPercent;

    public Double getDefectedPercent() {
        return defectedPercent;
    }

    public void setDefectedPercent(Double defectedPercent) {
        this.defectedPercent = defectedPercent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return title;
    }
}