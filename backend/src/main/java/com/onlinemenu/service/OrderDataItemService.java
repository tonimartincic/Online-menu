package com.onlinemenu.service;

import com.onlinemenu.domain.orderitem.OrderDataItemRequest;
import com.onlinemenu.domain.orderitem.OrderDataItemResponse;

import java.util.List;

public interface OrderDataItemService {

  List<OrderDataItemResponse> getAll();

  OrderDataItemResponse get(Long id);

  OrderDataItemResponse create(OrderDataItemRequest orderItemRequest);

  OrderDataItemResponse update(OrderDataItemRequest orderItemRequest);

  void delete(Long id);
}
