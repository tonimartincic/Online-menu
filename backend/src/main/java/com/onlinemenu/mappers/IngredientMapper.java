package com.onlinemenu.mappers;

import com.onlinemenu.domain.ingredient.Ingredient;
import com.onlinemenu.domain.ingredient.IngredientRequest;
import com.onlinemenu.domain.ingredient.IngredientResponse;

import java.util.ArrayList;
import java.util.List;

public class IngredientMapper {

  public static Ingredient mapIngredientRequestToIngredient(IngredientRequest ingredientRequest) {
    Ingredient ingredient = new Ingredient();

    ingredient.setId(ingredientRequest.getId());
    ingredient.setName(ingredientRequest.getName());

    return ingredient;
  }

  public static IngredientResponse mapIngredientToIngredientResponse(Ingredient ingredient) {
    IngredientResponse ingredientResponse = new IngredientResponse();

    ingredientResponse.setId(ingredient.getId());
    ingredientResponse.setName(ingredient.getName());

    return ingredientResponse;
  }

  public static List<Ingredient> mapIngredientRequestsToIngredients(List<IngredientRequest> ingredientRequests) {
    List<Ingredient> ingredients = new ArrayList<>();

    for (IngredientRequest ingredientRequest : ingredientRequests) {
      ingredients.add(mapIngredientRequestToIngredient(ingredientRequest));
    }

    return ingredients;
  }

  public static List<IngredientResponse> mapIngredientsToIngredientResponses(List<Ingredient> ingredients) {
    List<IngredientResponse> ingredientResponses = new ArrayList<>();

    for (Ingredient ingredient : ingredients) {
      ingredientResponses.add(mapIngredientToIngredientResponse(ingredient));
    }

    return ingredientResponses;
  }
}
