package com.onlinemenu.mappers;

import com.onlinemenu.domain.dish.Dish;
import com.onlinemenu.domain.dish.DishRequest;
import com.onlinemenu.domain.dish.DishResponse;
import com.onlinemenu.domain.dishingredient.DishIngredientResponse;

import java.util.ArrayList;
import java.util.List;

public class DishMapper {

  public static Dish mapDishRequestToDish(DishRequest dishRequest) {
    Dish dish = new Dish();

    dish.setId(dishRequest.getId());
    dish.setName(dishRequest.getName());
    dish.setPrice(dishRequest.getPrice());

    return dish;
  }

  public static DishResponse mapDishToDishResponse(Dish dish) {
    DishResponse dishResponse = new DishResponse();

    dishResponse.setId(dish.getId());
    dishResponse.setName(dish.getName());
    dishResponse.setPrice(dish.getPrice());

    List<DishIngredientResponse> dishIngredientResponses = DishIngredientMapper
      .mapDishIngredientsToDishIngredientResponses(dish.getDishIngredients());

    dishResponse.setDishIngredientResponses(dishIngredientResponses);

    return dishResponse;
  }

  public static List<Dish> mapDishRequestsToDishes(List<DishRequest> dishRequests) {
    List<Dish> dishes = new ArrayList<>();

    for (DishRequest dishRequest : dishRequests) {
      dishes.add(mapDishRequestToDish(dishRequest));
    }

    return dishes;
  }

  public static List<DishResponse> mapDishesToDishResponses(List<Dish> dishes) {
    List<DishResponse> dishResponses = new ArrayList<>();

    for (Dish dish : dishes) {
      dishResponses.add(mapDishToDishResponse(dish));
    }

    return dishResponses;
  }
}
