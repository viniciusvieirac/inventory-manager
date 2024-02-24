package com.example.inventorymanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventorymanager.controller.dto.ProductsDTO;
import com.example.inventorymanager.models.entities.Products;
import com.example.inventorymanager.service.ProductsService;

@RestController
@RequestMapping(path = "/products")
public class ProductsController {

  private final ProductsService productsService;

  @Autowired
  public ProductsController(ProductsService productsService) {
    this.productsService = productsService;
  }

  @GetMapping
  public ResponseEntity<List<ProductsDTO>> getProducts() {
    List<Products> allProducts = productsService.getProducts();
    List<ProductsDTO> allProductsDTO = allProducts.stream().map(ProductsDTO::fromEntity).toList();
    return ResponseEntity.ok(allProductsDTO);

  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getProductById(@PathVariable Long id) {
    Optional<Products> product = productsService.getProductById(id);
    ProductsDTO productDTO = ProductsDTO.fromEntity(product);
    return ResponseEntity.ok(productDTO);
  }

}
