package com.onlinemenu.service;

import com.onlinemenu.domain.order.OrderDataRequest;
import com.onlinemenu.domain.order.OrderDataResponse;

import java.util.List;

public interface OrderDataService {

  List<OrderDataResponse> getAll();

  OrderDataResponse get(Long id);

  OrderDataResponse create(OrderDataRequest orderRequest);

  OrderDataResponse update(OrderDataRequest orderRequest);

  void delete(Long id);

  void recalculateOrderData(Long id);
}
