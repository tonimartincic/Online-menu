package com.onlinemenu.service;

import com.onlinemenu.domain.order.OrderData;

public interface DeliveryPriceCalculationService {

  void calculateAndSetDeliveryPrice(OrderData order);
}
