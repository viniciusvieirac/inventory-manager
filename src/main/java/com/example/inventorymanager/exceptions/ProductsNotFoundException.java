package com.example.inventorymanager.exceptions;

/**
 * Exception thrown when a product is not found.
 */
public class ProductsNotFoundException extends RuntimeException {

  /**
   * Constructs a new ProductsNotFoundException with the specified detail message.
   * 
   */
  public ProductsNotFoundException() {
    super("Produto não encontrado!");
  }
}
