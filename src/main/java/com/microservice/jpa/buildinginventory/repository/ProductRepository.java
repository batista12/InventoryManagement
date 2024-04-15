package com.microservice.jpa.buildinginventory.repository;

import com.microservice.jpa.buildinginventory.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
