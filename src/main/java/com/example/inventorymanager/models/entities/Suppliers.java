package com.example.inventorymanager.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "suppliers")
public class Suppliers {
  private Long id;
  private String name;
  private String address;
  private String contact;

  public Suppliers(Long id, String name, String address, String contact) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.contact = contact;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }
}
