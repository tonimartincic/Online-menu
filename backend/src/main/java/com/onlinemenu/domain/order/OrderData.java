package com.onlinemenu.domain.order;

import com.onlinemenu.domain.orderitem.OrderDataItem;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class OrderData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "order")
  private List<OrderDataItem> orderItems;

  private Double totalPrice;

  private Double deliveryPrice;
}
