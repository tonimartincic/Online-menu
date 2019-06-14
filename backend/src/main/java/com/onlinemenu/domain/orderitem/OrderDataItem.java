package com.onlinemenu.domain.orderitem;

import com.onlinemenu.domain.dish.Dish;
import com.onlinemenu.domain.order.OrderData;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderDataItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "order_id")
  private Long orderId;

  @Column(name = "dish_id")
  private Long dishId;

  private Long count;

  @ManyToOne
  @JoinColumn(name = "order_id", insertable = false, updatable = false)
  private OrderData order;

  @ManyToOne
  @JoinColumn(name = "dish_id", insertable = false, updatable = false)
  private Dish dish;
}
