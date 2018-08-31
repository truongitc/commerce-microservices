package com.five9.catalogs.apiRepository;

import com.five9.catalogs.apiModel.Catalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends CrudRepository<Catalog,Integer> {

}
