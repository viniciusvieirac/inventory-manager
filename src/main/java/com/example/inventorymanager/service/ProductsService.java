package com.example.inventorymanager.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.inventorymanager.exceptions.ProductsNotFoundException;
import com.example.inventorymanager.models.entities.Products;
import com.example.inventorymanager.models.repositories.ProductsRepository;

/**
 * Service class for managing products.
 */
@Service
public class ProductsService {
  private final ProductsRepository productsRepository;

  @Autowired
  public ProductsService(ProductsRepository productsRepository) {
    this.productsRepository = productsRepository;
  }

  /**
   * Retrieves all products.
   * 
   * @return List of all products.
   */
  public List<Products> getProducts() {
    return productsRepository.findAll();
  }

  /**
   * Adds a new product.
   * 
   * @param products The product to add.
   * @return The added product.
   */
  public Products addNewProduct(Products products) {
    return productsRepository.save(products);
  }

  /**
   * Retrieves a product by its ID.
   * 
   * @param productId The ID of the product to retrieve.
   * @return The product with the specified ID, if present.
   */
  public Optional<Products> getProductById(Long productId) {
    return productsRepository.findById(productId);
  }

  /**
   * Updates an existing product.
   * 
   * @param productId The ID of the product to update.
   * @param products  The updated product data.
   * @return The updated product.
   * @throws ProductsNotFoundException if the product with the specified ID is not
   *                                   found.
   */
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
        .orElseThrow(() -> new ProductsNotFoundException("Produto não encontrado com o ID: " + productId));
  }
}
