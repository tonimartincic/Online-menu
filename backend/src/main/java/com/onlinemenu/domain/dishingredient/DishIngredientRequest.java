package com.onlinemenu.domain.dishingredient;

import lombok.Data;

@Data
public class DishIngredientRequest {

  private Long id;

  private Long dishId;

  private Long ingredientId;
}
