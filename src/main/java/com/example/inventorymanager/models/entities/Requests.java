package com.example.inventorymanager.models.entities;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "requests")
public class Requests {

  @Id
  @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
  private Long id;

  @CreatedDate
  private LocalDate date_requested;

  private String status;

  @OneToOne
  @JoinColumn(name = "supplier_id", referencedColumnName = "id")
  @JsonIgnore
  private Suppliers suppliers;

  @ManyToMany(mappedBy = "requests")
  @JsonIgnore
  private List<Products> products;

  public Requests(Long id, LocalDate date_requested, String status, Suppliers suppliers, Long product_id) {
    this.id = id;
    this.date_requested = date_requested;
    this.status = status;
    this.suppliers = suppliers;

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getDate_requested() {
    return date_requested;
  }

  public void setDate_requested(LocalDate date_requested) {
    this.date_requested = date_requested;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Suppliers getSupplier() {
    return suppliers;
  }

  public void setSupplier(Suppliers suppliers) {
    this.suppliers = suppliers;
  }

}
