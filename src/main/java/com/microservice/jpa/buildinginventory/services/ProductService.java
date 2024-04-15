package com.microservice.jpa.buildinginventory.services;

import com.microservice.jpa.buildinginventory.dto.ProductRequest;
import com.microservice.jpa.buildinginventory.dto.ProductResponse;
import com.microservice.jpa.buildinginventory.model.Product;
import com.microservice.jpa.buildinginventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {

        Product product = Product.builder().productName(productRequest.getProductName())
                .productDescription(productRequest.getProductDescription())
                .productPrice(productRequest.getProductPrice())
                .build();

    productRepository.save(product);
    log.info("Product is saved", product.getProductId());

    }

    public List<ProductResponse> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return  products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return  ProductResponse.builder()
                .productId(product.getProductId())
                .productDescription((product.getProductDescription()))
                .productPrice(product.getProductPrice())
                .build();
    }
}
