package com.five9.product.apiModel;

import java.io.Serializable;
public class Catalog implements Serializable {

    private Integer _id;
    private String catalogName;
    private Integer catalogParent;

    public Catalog() {
    }
    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }


    public Integer getCatalogParent() {
        return catalogParent;
    }

    public void setCatalogParent(Integer catalogParent) {
        this.catalogParent = catalogParent;
    }
}
