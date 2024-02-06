package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    public Product create(Product product) {
        productData.add(product);
        return product;
    }
    public Iterator<Product> findAll() {
        return productData.iterator();
    }
    public Product find(String productId){
        for (Product product : productData){
            if (product.getProductId().equals(productId)){
                return product;
            }
        }
        return null;
    }
    public Product editProduct(Product targetProduct) {
        String targetProductId = targetProduct.getProductId();
        String newName = targetProduct.getProductName();
        int newQuantity = targetProduct.getProductQuantity();
        for (Product storedProduct : productData) {
            String storedProductId = storedProduct.getProductId();
            if (storedProductId.equals(targetProductId)) {
                storedProduct.setProductName(newName);
                storedProduct.setProductQuantity(newQuantity);
                return storedProduct;
            }
        }
        return null;
    }
    public Product deleteProduct(Product targetProduct){
        String targetProductId = targetProduct.getProductId();
        for(Product product:productData){
            if(product.getProductId().equals(targetProductId)){
                productData.remove(product);
                return product;
            }
        }
        return null;
    }
}
