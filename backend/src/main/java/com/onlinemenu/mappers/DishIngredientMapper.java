package com.onlinemenu.mappers;

import com.onlinemenu.domain.dishingredient.DishIngredient;
import com.onlinemenu.domain.dishingredient.DishIngredientRequest;
import com.onlinemenu.domain.dishingredient.DishIngredientResponse;

import java.util.ArrayList;
import java.util.List;

public class DishIngredientMapper {

  public static DishIngredient mapDishIngredientRequestToDishIngredient(DishIngredientRequest dishIngredientRequest) {
    DishIngredient dishIngredient = new DishIngredient();

    dishIngredient.setId(dishIngredientRequest.getId());
    dishIngredient.setDishId(dishIngredientRequest.getDishId());
    dishIngredient.setIngredientId(dishIngredientRequest.getIngredientId());

    return dishIngredient;
  }

  public static List<DishIngredient> mapDishIngredientRequestsToDishIngredients(List<DishIngredientRequest> dishIngredientRequests) {
    List<DishIngredient> dishIngredients = new ArrayList<>();

    for (DishIngredientRequest dishIngredientRequest : dishIngredientRequests) {
      dishIngredients.add(mapDishIngredientRequestToDishIngredient(dishIngredientRequest));
    }

    return dishIngredients;
  }

  public static DishIngredientResponse mapDishIngredientToDishIngredientResponse(DishIngredient dishIngredient) {
    DishIngredientResponse dishIngredientResponse = new DishIngredientResponse();

    dishIngredientResponse.setId(dishIngredient.getId());
    dishIngredientResponse.setDishId(dishIngredient.getDish().getId());
    dishIngredientResponse.setDishName(dishIngredient.getDish().getName());
    dishIngredientResponse.setIngredientId(dishIngredient.getIngredient().getId());
    dishIngredientResponse.setIngredientName(dishIngredient.getIngredient().getName());

    return dishIngredientResponse;
  }

  public static List<DishIngredientResponse> mapDishIngredientsToDishIngredientResponses(List<DishIngredient> dishIngredients) {
    List<DishIngredientResponse> dishIngredientResponses = new ArrayList<>();

    for (DishIngredient dishIngredient : dishIngredients) {
      dishIngredientResponses.add(mapDishIngredientToDishIngredientResponse(dishIngredient));
    }

    return dishIngredientResponses;
  }
}
