package com.five9.product.apiServiceImpl;

import com.five9.product.apiModel.Product;
import com.five9.product.apiRepository.ProductRepository;
import com.five9.product.apiService.ProductServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServcie {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findOneProduct(Integer id){
        return productRepository.findOne(id);
    }

    @Override
    public Product saveNewProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product){
        productRepository.save(product);
    }

    @Override
    public List<Product> findAllProduct() {
        return (List<Product>) productRepository.findAll();
    }
}
