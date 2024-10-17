package com.innerconsulting.test.services;

import com.innerconsulting.test.models.ProductModel;
import com.innerconsulting.test.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    public ArrayList<ProductModel> getAll() {
        return (ArrayList<ProductModel>) productRepository.findAll();
    }

    public ProductModel create(ProductModel product) {
        return productRepository.save(product);
    }

    public ProductModel update(ProductModel request, Long id){
        try{
            ProductModel product = productRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

            product.setName(request.getName());
            product.setPrice(request.getPrice());

            return productRepository.save(product);

        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("[UPDATE PRODUCT]: " + e);
        }
    }

    public void delete(Long id){
        try{
            if(!productRepository.existsById(id)){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
            }
            productRepository.deleteById(id);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("[DELETE PRODUCT]: " + e);
        }
    }

}
