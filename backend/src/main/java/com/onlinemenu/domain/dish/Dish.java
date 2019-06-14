package com.onlinemenu.domain.dish;

import com.onlinemenu.domain.dishingredient.DishIngredient;
import com.onlinemenu.domain.orderitem.OrderDataItem;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Dish {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Double price;

  @OneToMany(mappedBy = "dish")
  private List<DishIngredient> dishIngredients;

  @OneToMany(mappedBy = "dish")
  private List<OrderDataItem> orderItems;
}
