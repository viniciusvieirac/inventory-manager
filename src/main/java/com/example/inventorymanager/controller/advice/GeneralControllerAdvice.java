package com.example.inventorymanager.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.inventorymanager.exceptions.ProductsNotFoundException;

/**
 * Controller advice to handle exceptions globally across all controllers.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * Exception handler for ProductsNotFoundException.
   * 
   * @param e The ProductsNotFoundException to handle.
   * @return ResponseEntity with HTTP status 404 (Not Found) and an error message.
   */
  @ExceptionHandler(ProductsNotFoundException.class)
  public ResponseEntity<String> handleProductsNotFoundException(ProductsNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
  }
}
