package com.example.inventorymanager.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.inventorymanager.models.entities.Requests;
import com.example.inventorymanager.models.repositories.RequestsRepository;

@Service
public class RequestsService {
  private final RequestsRepository requestsRepository;

  @Autowired
  public RequestsService(RequestsRepository requestsRepository) {
    this.requestsRepository = requestsRepository;
  }

  public List<Requests> getRequests() {
    return requestsRepository.findAll();
  }

  public Requests addNewRequest(Requests requests) {
    return requestsRepository.save(requests);
  }

  public Optional<Requests> getRequestById(Long requestId) {
    return requestsRepository.findById(requestId);
  }
}
