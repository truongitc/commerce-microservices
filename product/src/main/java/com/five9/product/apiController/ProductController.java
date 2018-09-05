package com.five9.product.apiController;


import com.five9.product.apiModel.Catalog;
import com.five9.product.apiModel.Product;
import com.five9.product.apiService.ProductServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RefreshScope
public class ProductController {

    @Autowired
    FeignCatalog feignCatalog;

    @Autowired
    private ProductServcie productServcie;

    @GetMapping("/")
    public String hello(){
        return "product";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> listALLProducts(){


        List<Product> list = productServcie.findAllProduct();

        for (Product p: list) {
            //list.add(feignCatalog.findOneCatalog(p.getCatalogId()).getCatalogName());
        }

        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findOneProduct(@PathVariable Integer id){
        Product product = productServcie.findOneProduct(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/products",headers="Accept=application/json")
    public ResponseEntity<Void> handlerCreateNewProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder){
        HttpHeaders headers = new HttpHeaders();
        Product prod = productServcie.saveNewProduct(product);
        headers.setLocation(ucBuilder.path("/products/{id}").buildAndExpand(prod.get_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/products/{id}" , headers="Accept=application/json")
    public ResponseEntity<String> handlerEditProduct(@RequestBody Product product, @PathVariable Integer id){

        Product prod = productServcie.findOneProduct(id);
        if(prod == null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }

        prod.setUrl(product.getUrl());
        prod.setPrice(product.getPrice());
        prod.setName(product.getName());
        prod.setImage(product.getImage());
        prod.setDescription(product.getDescription());
        prod.setCurrency(product.getCurrency());

        productServcie.updateProduct(prod);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @FeignClient("catalog")
    interface FeignCatalog{
        @GetMapping("/catalogs")
        List<Catalog> findAllCatalog();

        @GetMapping("/catalogs/{id}")
        Catalog findOneCatalog(@PathVariable("id") Integer id);
    }

    @GetMapping("/feign")
    public ResponseEntity<List<Catalog>> handlerFindAllCatalog(){
        List<Catalog> catalogs = feignCatalog.findAllCatalog();
        return new ResponseEntity<List<Catalog>>(catalogs, HttpStatus.OK);
    }

    @GetMapping("/feign/{id}")
    public ResponseEntity<Catalog> handlerFindOneCatalog(@PathVariable Integer id) {
        System.out.println("id" + id);
        Catalog catalog = feignCatalog.findOneCatalog(id);
        return new ResponseEntity<Catalog>(catalog, HttpStatus.OK);
    }
}
