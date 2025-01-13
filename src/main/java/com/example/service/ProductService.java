package com.example.service;

import com.example.controller.form.AddProductForm;
import com.example.controller.form.EditProductForm;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import com.example.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(AddProductForm form, MultipartFile image, HttpServletRequest request) {
        productRepository.add(Product.builder()
                .image(FileUtil.uploadFile(image, "", request))
                .name(form.getName())
                .description(form.getDescription())
                .price(form.getPrice())
                .stock(form.getStock())
                .build());
    }

    public Product getProduct(Integer id) {
        return productRepository.findById(id);
    }

    public void editProduct(EditProductForm form, MultipartFile image, HttpServletRequest request) {
        Product product = productRepository.findById(form.getId());
        product.setImage(FileUtil.uploadFile(image, product.getImage(), request));
        product.setName(form.getName());
        product.setDescription(form.getDescription());
        product.setPrice(form.getPrice());
        product.setStock(form.getStock());
        productRepository.edit(product);
    }
    public void deleteProduct(Integer id) {
        productRepository.delete(id);
    }
}
