package com.example.inventorymanager.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inventorymanager.models.entities.Suppliers;

@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {

}
