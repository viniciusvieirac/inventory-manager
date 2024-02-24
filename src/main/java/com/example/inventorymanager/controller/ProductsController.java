package com.example.inventorymanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventorymanager.controller.dto.ProductsDTO;
import com.example.inventorymanager.exceptions.ProductsNotFoundException;
import com.example.inventorymanager.models.entities.Products;
import com.example.inventorymanager.service.ProductsService;

/**
 * Controller for managing products.
 */
@RestController
@RequestMapping(path = "/products")
public class ProductsController {

  private final ProductsService productsService;

  @Autowired
  public ProductsController(ProductsService productsService) {
    this.productsService = productsService;
  }

  /**
   * Retrieves all products.
   * 
   * @return ResponseEntity with HTTP status OK and a list of ProductsDTO
   *         representing all products.
   */
  @GetMapping
  public ResponseEntity<List<ProductsDTO>> getProducts() {
    List<Products> allProducts = productsService.getProducts();
    List<ProductsDTO> allProductsDTO = allProducts.stream().map(ProductsDTO::fromEntity).toList();
    return ResponseEntity.ok(allProductsDTO);
  }

  /**
   * Retrieves a product by its ID.
   * 
   * @param id The ID of the product to retrieve.
   * @return ResponseEntity with HTTP status OK and the ProductsDTO representing
   *         the product.
   * @throws ProductsNotFoundException if the product with the specified ID is not
   *                                   found.
   */
  @GetMapping("/{id}")
  public ResponseEntity<ProductsDTO> getProductById(@PathVariable Long id) throws ProductsNotFoundException {
    Products productById = productsService.getProductById(id)
        .orElseThrow(() -> new ProductsNotFoundException("Produto não encontrado com o ID: " + id));
    return ResponseEntity.ok(ProductsDTO.fromEntity(productById));
  }

  /**
   * Adds a new product.
   * 
   * @param productsDTO The DTO representing the new product.
   * @return ResponseEntity with HTTP status CREATED and the ProductsDTO
   *         representing the newly added product.
   */
  @PostMapping
  public ResponseEntity<ProductsDTO> addNewProduct(@RequestBody ProductsDTO productsDTO) {
    Products newProduct = productsService.addNewProduct(productsDTO.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(ProductsDTO.fromEntity(newProduct));
  }

  /**
   * Updates an existing product.
   * 
   * @param id          The ID of the product to update.
   * @param productsDTO The DTO representing the updated product data.
   * @return ResponseEntity with HTTP status OK and the ProductsDTO representing
   *         the updated product.
   */
  @PutMapping("/{id}")
  public ResponseEntity<ProductsDTO> updateProduct(@PathVariable Long id, @RequestBody ProductsDTO productsDTO) {
    Products updatedProduct = productsService.updateProduct(id, productsDTO.toEntity());
    return ResponseEntity.ok(ProductsDTO.fromEntity(updatedProduct));
  }
}
