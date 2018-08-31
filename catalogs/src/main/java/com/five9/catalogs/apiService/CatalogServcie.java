package com.five9.catalogs.apiService;

import com.five9.catalogs.apiModel.Catalog;

import java.util.List;

public interface CatalogServcie {

    public Catalog findOneCatalog(Integer id);

    public Catalog saveNewCatalog(Catalog product);

    public void updateCatalog(Catalog catalog);

    public List<Catalog> findAllCatalog();
}
