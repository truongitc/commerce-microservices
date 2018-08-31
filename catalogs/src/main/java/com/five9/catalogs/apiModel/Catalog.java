package com.five9.catalogs.apiModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "catalog")
public class Catalog implements Serializable {

    private Integer _id;
    private String catalogName;
    private Integer catalogParent;

    public Catalog() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    @Column(name = "catalog_name")
    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    @Column(name = "catalog_parent")
    public Integer getCatalogParent() {
        return catalogParent;
    }

    public void setCatalogParent(Integer catalogParent) {
        this.catalogParent = catalogParent;
    }
}
