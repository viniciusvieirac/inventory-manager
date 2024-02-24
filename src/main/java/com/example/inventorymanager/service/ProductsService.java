package com.example.inventorymanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventorymanager.exceptions.ProductsNotFoundException;
import com.example.inventorymanager.models.entities.Products;
import com.example.inventorymanager.models.repositories.ProductsRepository;

@Service
public class ProductsService {
  private final ProductsRepository productsRepository;

  @Autowired
  public ProductsService(ProductsRepository productsRepository) {
    this.productsRepository = productsRepository;
  }

  public List<Products> getProducts() {
    return productsRepository.findAll();
  }

  public Products addNewProduct(Products products) {
    return productsRepository.save(products);
  }

  public Optional<Products> getProductById(Long productId) {
    return productsRepository.findById(productId);
  }

  public Products updateProduct(Long productId, Products products) {
    return productsRepository.findById(productId)
        .map(existingProduct -> {
          if (products.getName() != null) {
            existingProduct.setName(products.getName());
          }
          if (products.getDescription() != null) {
            existingProduct.setDescription(products.getDescription());
          }
          if (products.getPrice() != null) {
            existingProduct.setPrice(products.getPrice());
          }
          if (products.getQuantity() != null) {
            existingProduct.setQuantity(products.getQuantity());
          }
          return productsRepository.save(existingProduct);
        })
        .orElseThrow(() -> new ProductsNotFoundException());
  }

}
