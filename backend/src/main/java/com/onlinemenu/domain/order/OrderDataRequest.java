package com.onlinemenu.domain.order;

import com.onlinemenu.domain.orderitem.OrderDataItemRequest;
import lombok.Data;

import java.util.List;

@Data
public class OrderDataRequest {

  private Long id;

  private List<OrderDataItemRequest> orderItemRequests;
}
