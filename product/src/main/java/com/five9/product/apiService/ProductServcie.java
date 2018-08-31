package com.five9.product.apiService;

import com.five9.product.apiModel.Product;

import java.util.List;

public interface ProductServcie {

    Product findOneProduct(Integer id);

    Product saveNewProduct(Product product);

    void updateProduct(Product prod);

    List<Product> findAllProduct();
}
