package com.innerconsulting.test.services;

import com.innerconsulting.test.models.ProductModel;
import com.innerconsulting.test.repositories.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private List<ProductModel> products;


    @BeforeEach
    void setUp() {
        products = new ArrayList<>();

       ProductModel product1 = new ProductModel();
       product1.setId(1L);
       product1.setName("Product 1");
       product1.setPrice(100.1);

       ProductModel product2 = new ProductModel();
       product2.setId(2L);
       product2.setName("Product 2");
       product2.setPrice(200.2);

       products.add(product1);
       products.add(product2);
    }

    @Test
    public void testGetAll() {


        when(productRepository.findAll()).thenReturn(products);

        ArrayList<ProductModel> result = productService.getAll();

        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testCreate() {
        when(productRepository.save(any(ProductModel.class))).thenReturn(products.get(0));

        ProductModel result = productService.create(products.get(0));

        assertNotNull(result);
        assertEquals("Product 1", result.getName());
        assertEquals(100.1, result.getPrice());
    }

    @Test
    public void testUpdate() {
        ProductModel request = new ProductModel();
        request.setName("Product 1 EDIT");
        request.setPrice(999.9);

        Long productId = 1L;

        when(productRepository.findById(productId)).thenReturn(Optional.of(products.get(0)));
        when(productRepository.save(any(ProductModel.class))).thenReturn(products.get(0));

        ProductModel result = productService.update(request, productId);

        assertNotNull(result);
        assertEquals("Product 1 EDIT", result.getName());
    }

}