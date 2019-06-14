package com.onlinemenu.domain.dishingredient;

import com.onlinemenu.domain.dish.Dish;
import com.onlinemenu.domain.ingredient.Ingredient;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DishIngredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "dish_id")
  private Long dishId;

  @Column(name = "ingredient_id")
  private Long ingredientId;

  @ManyToOne
  @JoinColumn(name = "dish_id", insertable = false, updatable = false)
  private Dish dish;

  @ManyToOne
  @JoinColumn(name = "ingredient_id", insertable = false, updatable = false)
  private Ingredient ingredient;
}
