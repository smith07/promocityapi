package com.azeka.promocityapi.com.azeka.promocityapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="image")
public class Image implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "url")
    private String url;

    //@ManyToOne
    //@JoinColumn(name = "id")
    //private Sale sale;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
