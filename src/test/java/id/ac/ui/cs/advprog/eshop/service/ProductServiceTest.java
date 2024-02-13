package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());

        Iterator<Product> iterator = productList.iterator();
        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> foundProducts = productService.findAll();

        assertEquals(productList.size(), foundProducts.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testFindProduct() {
        String productId = "123";
        Product expectedProduct = new Product();
        when(productRepository.find(productId)).thenReturn(expectedProduct);

        Product foundProduct = productService.find(productId);

        assertEquals(expectedProduct, foundProduct);
        verify(productRepository, times(1)).find(productId);
    }

    @Test
    void testEditProduct() {
        Product product = new Product();
        when(productRepository.editProduct(product)).thenReturn(product);

        Product editedProduct = productService.editProduct(product);

        assertEquals(product, editedProduct);
        verify(productRepository, times(1)).editProduct(product);
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        when(productRepository.deleteProduct(product)).thenReturn(product);

        Product deletedProduct = productService.deleteProduct(product);

        assertEquals(product, deletedProduct);
        verify(productRepository, times(1)).deleteProduct(product);
    }
}
