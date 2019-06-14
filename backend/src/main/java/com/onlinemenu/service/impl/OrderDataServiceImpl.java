package com.onlinemenu.service.impl;

import com.onlinemenu.domain.order.OrderData;
import com.onlinemenu.domain.order.OrderDataRequest;
import com.onlinemenu.domain.order.OrderDataResponse;
import com.onlinemenu.domain.orderitem.OrderDataItem;
import com.onlinemenu.mappers.OrderMapper;
import com.onlinemenu.repository.OrderDataRepository;
import com.onlinemenu.service.DeliveryPriceCalculationService;
import com.onlinemenu.service.OrderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDataServiceImpl implements OrderDataService {

  private OrderDataRepository orderRepository;

  private DeliveryPriceCalculationService deliveryPriceCalculationService;

  @Autowired
  public OrderDataServiceImpl(
    OrderDataRepository orderRepository,
    DeliveryPriceCalculationService deliveryPriceCalculationService) {
    this.orderRepository = orderRepository;
    this.deliveryPriceCalculationService = deliveryPriceCalculationService;
  }

  @Override
  public List<OrderDataResponse> getAll() {
    List<OrderData> orders = this.orderRepository.findAll();

    List<OrderDataResponse> orderResponses = OrderMapper.mapOrdersToOrderResponses(orders);
    return orderResponses;
  }

  @Override
  public OrderDataResponse get(Long id) {
    OrderData order = this.orderRepository.getOne(id);

    OrderDataResponse orderResponse = OrderMapper.mapOrderToOrderResponse(order);
    return orderResponse;
  }

  @Override
  public OrderDataResponse create(OrderDataRequest orderRequest) {
    OrderData order = OrderMapper.mapOrderRequestToOrder(orderRequest);

    calculateAndSetTotalPrice(order);
    deliveryPriceCalculationService.calculateAndSetDeliveryPrice(order);

    OrderData createdOrder = this.orderRepository.save(order);

    OrderDataResponse orderResponse = OrderMapper.mapOrderToOrderResponse(createdOrder);
    return orderResponse;
  }

  @Override
  public OrderDataResponse update(OrderDataRequest orderRequest) {
    OrderData order = OrderMapper.mapOrderRequestToOrder(orderRequest);

    calculateAndSetTotalPrice(order);
    deliveryPriceCalculationService.calculateAndSetDeliveryPrice(order);

    OrderData updatedOrder = this.orderRepository.save(order);

    OrderDataResponse orderResponse = OrderMapper.mapOrderToOrderResponse(updatedOrder);
    return orderResponse;
  }

  @Override
  public void delete(Long id) {
    this.orderRepository.deleteById(id);
  }

  @Override
  public void recalculateOrderData(Long id) {
    OrderData orderData = this.orderRepository.getOne(id);

    calculateAndSetTotalPrice(orderData);
    deliveryPriceCalculationService.calculateAndSetDeliveryPrice(orderData);

    this.orderRepository.save(orderData);
  }

  private void calculateAndSetTotalPrice(OrderData order) {
    Double totalPrice = 0.0;
    for (OrderDataItem orderItem : order.getOrderItems()) {
      totalPrice += orderItem.getDish().getPrice() * orderItem.getCount();
    }

    order.setTotalPrice(totalPrice);
  }
}
