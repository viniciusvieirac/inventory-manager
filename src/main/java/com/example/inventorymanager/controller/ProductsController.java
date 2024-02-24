package com.example.inventorymanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<List<Products>>  getProducts() {
    return productsService.getProducts();
  }

  @GetMapping
  public Products
}
