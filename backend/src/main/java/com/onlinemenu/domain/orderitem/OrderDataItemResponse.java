package com.onlinemenu.domain.orderitem;

import com.onlinemenu.domain.dish.Dish;
import lombok.Data;

@Data
public class OrderDataItemResponse {

  private Long id;

  private Dish dish;

  private Long count;
}
