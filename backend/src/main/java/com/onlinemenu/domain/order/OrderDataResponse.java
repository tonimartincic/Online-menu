package com.onlinemenu.domain.order;

import com.onlinemenu.domain.orderitem.OrderDataItemResponse;
import lombok.Data;

import java.util.List;

@Data
public class OrderDataResponse {

  private Long id;

  private List<OrderDataItemResponse> orderItemResponses;

  private Double totalPrice;

  private Double deliveryPrice;
}
