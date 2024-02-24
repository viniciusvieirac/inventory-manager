package com.example.inventorymanager.controller.dto;

import com.example.inventorymanager.models.entities.Products;

/**
 * Data Transfer Object (DTO) for transferring Products data between layers of
 * the application.
 */
public record ProductsDTO(
    Long id, String name, String description, String price, String quantity) {

  /**
   * Constructs a ProductsDTO object from a Products entity.
   * 
   * @param products The Products entity to convert to DTO.
   * @return The ProductsDTO object representing the provided Products entity.
   */
  public static ProductsDTO fromEntity(Products products) {
    return new ProductsDTO(
        products.getId(),
        products.getName(),
        products.getDescription(),
        products.getPrice(),
        products.getQuantity());
  }

  /**
   * Converts the ProductsDTO object to a Products entity.
   * 
   * @return The Products entity represented by this ProductsDTO.
   */
  public Products toEntity() {
    return new Products(id, name, description, price, quantity);
  }
}
