package com.five9.catalogs.apiServiceImpl;

import com.five9.catalogs.apiModel.Catalog;
import com.five9.catalogs.apiRepository.CatalogRepository;
import com.five9.catalogs.apiService.CatalogServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CatalogServiceImpl implements CatalogServcie {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public Catalog findOneCatalog(Integer id) {
        return catalogRepository.findOne(id);
    }

    @Override
    public Catalog saveNewCatalog(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public void updateCatalog(Catalog catalog){
        catalogRepository.save(catalog);
    }

    @Override
    public List<Catalog> findAllCatalog() {
        return (List<Catalog>) catalogRepository.findAll();
    }
}
