package com.five9.catalogs.apiController;

import com.five9.catalogs.apiModel.Catalog;
import com.five9.catalogs.apiService.CatalogServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    private CatalogServcie catalogServcie;

    @GetMapping("/")
    public String hello(){
        return "catalog";
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<Catalog>> handlerFindAllCatalog(){
        List<Catalog> catalogs = catalogServcie.findAllCatalog();
        return  new ResponseEntity<List<Catalog>>(catalogs, HttpStatus.OK);
    }

    @GetMapping("/catalogs/{id}")
    public ResponseEntity<Catalog> findOneCatalog(@PathVariable Integer id){
        Catalog catalog = catalogServcie.findOneCatalog(id);
        return new ResponseEntity<Catalog>(catalog, HttpStatus.OK);
    }

    @PostMapping(value = "/catalogs",headers="Accept=application/json")
    public ResponseEntity<Void> handlerCreateNewCatalog(@RequestBody Catalog catalog, UriComponentsBuilder ucBuilder){
        HttpHeaders headers = new HttpHeaders();
        Catalog prod = catalogServcie.saveNewCatalog(catalog);
        headers.setLocation(ucBuilder.path("/catalogs/{id}").buildAndExpand(prod.get_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/catalogs/{id}" , headers="Accept=application/json")
    public ResponseEntity<String> handlerEditCatalog(@RequestBody Catalog catalog, @PathVariable Integer id){

        Catalog catg = catalogServcie.findOneCatalog(id);
        if(catg == null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }

        catg.setCatalogName(catalog.getCatalogName());
        if(catalog.getCatalogParent() == 0){
            catg.setCatalogParent(0);
        }
        catg.setCatalogParent(catalog.getCatalogParent());

        catalogServcie.updateCatalog(catg);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
