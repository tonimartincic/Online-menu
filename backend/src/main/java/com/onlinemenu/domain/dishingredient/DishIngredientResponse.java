package com.onlinemenu.domain.dishingredient;

import lombok.Data;

@Data
public class DishIngredientResponse {

  private Long id;

  private Long dishId;

  private String dishName;

  private Long ingredientId;

  private String ingredientName;
}
