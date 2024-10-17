package com.innerconsulting.test.controllers;

import com.innerconsulting.test.models.ProductModel;
import com.innerconsulting.test.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "Retrieve a list of products", description = "Returns a list of all available products.")
    public ArrayList<ProductModel> getProducts() {
        return this.productService.getAll();
    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Adds a new product to the db.")
    public ProductModel createProduct(@RequestBody ProductModel product) {
        return this.productService.create(product);
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "Update an existing product", description = "Updates the details of an existing product.")
    public ProductModel updateProduct(@Parameter(description = "ID of the product to be updated") @PathVariable Long id, @RequestBody ProductModel product) {
        return this.productService.update(product, id);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Delete a product", description = "Removes a product from the inventory.")
    public void deleteProduct(@Parameter(description = "ID of the product to be deleted") @PathVariable Long id){

        this.productService.delete(id);
    }
}
