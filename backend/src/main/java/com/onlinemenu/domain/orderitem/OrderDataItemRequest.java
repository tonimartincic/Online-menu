package com.onlinemenu.domain.orderitem;

import lombok.Data;

@Data
public class OrderDataItemRequest {

  private Long id;

  private Long orderId;

  private Long dishId;

  private Long count;
}
