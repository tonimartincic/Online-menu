package com.onlinemenu.controller;

import com.onlinemenu.domain.order.OrderDataRequest;
import com.onlinemenu.domain.order.OrderDataResponse;
import com.onlinemenu.service.OrderDataService;
import org.apache.commons.lang.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDataController {

  private final OrderDataService orderService;

  @Autowired
  public OrderDataController(final OrderDataService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/api/orders")
  public List<OrderDataResponse> getAll() {
    return this.orderService.getAll();
  }

  @GetMapping("/api/orders/{id}")
  public OrderDataResponse get(@PathVariable final Long id) {
    return this.orderService.get(id);
  }

  @PostMapping("/api/orders")
  public OrderDataResponse create(@RequestBody final OrderDataRequest orderRequest) {
    if (orderRequest == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.orderService.create(orderRequest);
  }

  @PutMapping("/api/orders")
  public OrderDataResponse update(@RequestBody final OrderDataRequest orderRequest) {
    if (orderRequest == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.orderService.update(orderRequest);
  }

  @DeleteMapping("/api/orders/{id}")
  public void delete(@PathVariable final Long id) {
    this.orderService.delete(id);
  }
}
