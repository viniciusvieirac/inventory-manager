package com.example.inventorymanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventorymanager.models.entities.Suppliers;
import com.example.inventorymanager.models.repositories.SuppliersRepository;

@Service
public class SuppliersService {
  private final SuppliersRepository suppliersRepository;

  @Autowired
  public SuppliersService(SuppliersRepository suppliersRepository) {
    this.suppliersRepository = suppliersRepository;
  }

  public List<Suppliers> getSuppliers() {
    return suppliersRepository.findAll();
  }

  public Suppliers addNewSupplier(Suppliers suppliers) {
    return suppliersRepository.save(suppliers);
  }

  public Optional<Suppliers> getSupplierById(Long supplierId) {
    return suppliersRepository.findById(supplierId);
  }
}
