package com.onlinemenu.mappers;

import com.onlinemenu.domain.order.OrderData;
import com.onlinemenu.domain.order.OrderDataRequest;
import com.onlinemenu.domain.order.OrderDataResponse;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

  public static OrderData mapOrderRequestToOrder(OrderDataRequest orderRequest) {
    OrderData order = new OrderData();

    order.setId(orderRequest.getId());
    order.setOrderItems(OrderItemMapper.mapOrderItemRequestsToOrderItems(orderRequest.getOrderItemRequests()));

    return order;
  }

  public static OrderDataResponse mapOrderToOrderResponse(OrderData order) {
    OrderDataResponse orderResponse = new OrderDataResponse();

    orderResponse.setId(order.getId());
    orderResponse.setOrderItemResponses(OrderItemMapper.mapOrderItemsToOrderItemResponses(order.getOrderItems()));
    orderResponse.setTotalPrice(order.getTotalPrice());
    orderResponse.setDeliveryPrice(order.getDeliveryPrice());

    return orderResponse;
  }

  public static List<OrderData> mapOrderRequestsToOrders(List<OrderDataRequest> orderRequests) {
    List<OrderData> orders = new ArrayList<>();

    for (OrderDataRequest orderRequest : orderRequests) {
      orders.add(mapOrderRequestToOrder(orderRequest));
    }

    return orders;
  }

  public static List<OrderDataResponse> mapOrdersToOrderResponses(List<OrderData> orders) {
    List<OrderDataResponse> orderResponses = new ArrayList<>();

    for (OrderData order : orders) {
      orderResponses.add(mapOrderToOrderResponse(order));
    }

    return orderResponses;
  }
}
