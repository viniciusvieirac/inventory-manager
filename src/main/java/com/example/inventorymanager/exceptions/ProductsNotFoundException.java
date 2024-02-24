package com.example.inventorymanager.exceptions;

/**
 * Exception thrown when a product is not found.
 */
public class ProductsNotFoundException extends RuntimeException {

  /**
   * Constructs a new ProductsNotFoundException with the specified detail message.
   * 
   * @param message The detail message (which is saved for later retrieval by the
   *                getMessage() method).
   */
  public ProductsNotFoundException(String message) {
    super(message);
  }
}
