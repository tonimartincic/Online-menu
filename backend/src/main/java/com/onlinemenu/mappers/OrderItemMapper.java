package com.onlinemenu.mappers;

import com.onlinemenu.domain.orderitem.OrderDataItem;
import com.onlinemenu.domain.orderitem.OrderDataItemRequest;
import com.onlinemenu.domain.orderitem.OrderDataItemResponse;

import java.util.ArrayList;
import java.util.List;

public class OrderItemMapper {

  public static OrderDataItem mapOrderItemRequestToOrderItem(OrderDataItemRequest orderItemRequest) {
    OrderDataItem orderItem = new OrderDataItem();

    orderItem.setId(orderItemRequest.getId());
    orderItem.setOrderId(orderItemRequest.getOrderId());
    orderItem.setDishId(orderItemRequest.getDishId());
    orderItem.setCount(orderItemRequest.getCount());

    return orderItem;
  }

  public static OrderDataItemResponse mapOrderItemToOrderItemResponse(OrderDataItem orderItem) {
    OrderDataItemResponse orderItemResponse = new OrderDataItemResponse();

    orderItemResponse.setId(orderItem.getId());
    orderItemResponse.setDish(orderItem.getDish());
    orderItemResponse.setCount(orderItem.getCount());

    return orderItemResponse;
  }

  public static List<OrderDataItem> mapOrderItemRequestsToOrderItems(List<OrderDataItemRequest> orderItemRequests) {
    List<OrderDataItem> orderItems = new ArrayList<>();

    for (OrderDataItemRequest orderItemRequest : orderItemRequests) {
      orderItems.add(mapOrderItemRequestToOrderItem(orderItemRequest));
    }

    return orderItems;
  }

  public static List<OrderDataItemResponse> mapOrderItemsToOrderItemResponses(List<OrderDataItem> orderItems) {
    List<OrderDataItemResponse> orderItemResponses = new ArrayList<>();

    for (OrderDataItem orderItem : orderItems) {
      orderItemResponses.add(mapOrderItemToOrderItemResponse(orderItem));
    }

    return orderItemResponses;
  }
}
