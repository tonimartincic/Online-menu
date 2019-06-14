package com.onlinemenu.service;

import com.onlinemenu.domain.ingredient.IngredientRequest;
import com.onlinemenu.domain.ingredient.IngredientResponse;

import java.util.List;

public interface IngredientService {

  List<IngredientResponse> getAll();

  IngredientResponse get(Long id);

  IngredientResponse create(IngredientRequest ingredientRequest);

  IngredientResponse update(IngredientRequest ingredientRequest);

  void delete(Long id);
}
