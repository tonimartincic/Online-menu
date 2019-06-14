package com.onlinemenu.service;

import com.onlinemenu.domain.dishingredient.DishIngredientRequest;
import com.onlinemenu.domain.dishingredient.DishIngredientResponse;

import java.util.List;

public interface DishIngredientService {

  List<DishIngredientResponse> getAll();

  DishIngredientResponse get(Long id);

  DishIngredientResponse create(DishIngredientRequest dishIngredientRequest);

  DishIngredientResponse update(DishIngredientRequest dishIngredientRequest);

  void delete(Long id);
}
