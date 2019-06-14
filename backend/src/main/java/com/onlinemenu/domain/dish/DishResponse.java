package com.onlinemenu.domain.dish;

import com.onlinemenu.domain.dishingredient.DishIngredientResponse;
import lombok.Data;

import java.util.List;

@Data
public class DishResponse {

  private Long id;

  private String name;

  private Double price;

  private List<DishIngredientResponse> dishIngredientResponses;
}
