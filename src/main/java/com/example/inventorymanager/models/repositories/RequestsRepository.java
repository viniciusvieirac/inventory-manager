package com.example.inventorymanager.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventorymanager.models.entities.Requests;

public interface RequestsRepository extends JpaRepository<Requests, Long> {

}
