package com.onlinemenu.controller;

import com.onlinemenu.domain.orderitem.OrderDataItemRequest;
import com.onlinemenu.domain.orderitem.OrderDataItemResponse;
import com.onlinemenu.service.OrderDataItemService;
import org.apache.commons.lang.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDataItemController {

  private final OrderDataItemService orderItemService;

  @Autowired
  public OrderDataItemController(final OrderDataItemService orderItemService) {
    this.orderItemService = orderItemService;
  }

  @GetMapping("/api/order-items")
  public List<OrderDataItemResponse> getAll() {
    return this.orderItemService.getAll();
  }

  @GetMapping("/api/order-items/{id}")
  public OrderDataItemResponse get(@PathVariable final Long id) {
    return this.orderItemService.get(id);
  }

  @PostMapping("/api/order-items")
  public OrderDataItemResponse create(@RequestBody final OrderDataItemRequest orderItemRequest) {
    if (orderItemRequest == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.orderItemService.create(orderItemRequest);
  }

  @PutMapping("/api/order-items")
  public OrderDataItemResponse update(@RequestBody final OrderDataItemRequest orderItemRequest) {
    if (orderItemRequest == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.orderItemService.update(orderItemRequest);
  }

  @DeleteMapping("/api/order-items/{id}")
  public void delete(@PathVariable final Long id) {
    this.orderItemService.delete(id);
  }
}
