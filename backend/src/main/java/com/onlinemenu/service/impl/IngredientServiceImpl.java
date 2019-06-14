package com.onlinemenu.service.impl;

import com.onlinemenu.domain.ingredient.Ingredient;
import com.onlinemenu.domain.ingredient.IngredientRequest;
import com.onlinemenu.domain.ingredient.IngredientResponse;
import com.onlinemenu.mappers.IngredientMapper;
import com.onlinemenu.repository.IngredientRepository;
import com.onlinemenu.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class IngredientServiceImpl implements IngredientService {

  private IngredientRepository ingredientRepository;

  @Autowired
  public IngredientServiceImpl(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  @Override
  public List<IngredientResponse> getAll() {
    List<Ingredient> ingredients = this.ingredientRepository.findAll();

    List<IngredientResponse> ingredientResponses = IngredientMapper.mapIngredientsToIngredientResponses(ingredients);
    return ingredientResponses;
  }

  @Override
  public IngredientResponse get(Long id) {
    Ingredient ingredient = this.ingredientRepository.getOne(id);

    IngredientResponse ingredientResponse = IngredientMapper.mapIngredientToIngredientResponse(ingredient);
    return ingredientResponse;
  }

  @Override
  public IngredientResponse create(IngredientRequest ingredientRequest) {
    Ingredient existingIngredient = ingredientRepository.findByName(ingredientRequest.getName());
    if (existingIngredient != null) {
      throw new IllegalArgumentException("Ingredient with given name already exists.");
    }

    Ingredient ingredient = IngredientMapper.mapIngredientRequestToIngredient(ingredientRequest);
    Ingredient createdIngredient = this.ingredientRepository.save(ingredient);

    IngredientResponse ingredientResponse = IngredientMapper.mapIngredientToIngredientResponse(createdIngredient);
    return ingredientResponse;
  }

  @Override
  public IngredientResponse update(IngredientRequest ingredientRequest) {
    Ingredient existingIngredient = ingredientRepository.findByName(ingredientRequest.getName());
    if (existingIngredient != null && !Objects.equals(existingIngredient.getId(), ingredientRequest.getId())) {
      throw new IllegalArgumentException("Ingredient with given name already exists.");
    }

    Ingredient ingredient = IngredientMapper.mapIngredientRequestToIngredient(ingredientRequest);
    Ingredient updatedIngredient = this.ingredientRepository.save(ingredient);

    IngredientResponse ingredientResponse = IngredientMapper.mapIngredientToIngredientResponse(updatedIngredient);
    return ingredientResponse;
  }

  @Override
  public void delete(Long id) {
    this.ingredientRepository.deleteById(id);
  }
}
