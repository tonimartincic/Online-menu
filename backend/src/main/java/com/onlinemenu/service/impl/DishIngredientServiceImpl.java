package com.onlinemenu.service.impl;

import com.onlinemenu.domain.dishingredient.DishIngredient;
import com.onlinemenu.domain.dishingredient.DishIngredientRequest;
import com.onlinemenu.domain.dishingredient.DishIngredientResponse;
import com.onlinemenu.mappers.DishIngredientMapper;
import com.onlinemenu.repository.DishIngredientRepository;
import com.onlinemenu.service.DishIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishIngredientServiceImpl implements DishIngredientService {

  private DishIngredientRepository dishIngredientRepository;

  @Autowired
  public DishIngredientServiceImpl(DishIngredientRepository dishIngredientRepository) {
    this.dishIngredientRepository = dishIngredientRepository;
  }

  @Override
  public List<DishIngredientResponse> getAll() {
    List<DishIngredient> dishIngredients = this.dishIngredientRepository.findAll();

    List<DishIngredientResponse> dishIngredientResponses = DishIngredientMapper
      .mapDishIngredientsToDishIngredientResponses(dishIngredients);

    return dishIngredientResponses;
  }

  @Override
  public DishIngredientResponse get(Long id) {
    DishIngredient dish = this.dishIngredientRepository.getOne(id);

    DishIngredientResponse dishIngredientResponse = DishIngredientMapper.mapDishIngredientToDishIngredientResponse(dish);
    return dishIngredientResponse;
  }

  @Override
  public DishIngredientResponse create(DishIngredientRequest dishIngredientRequest) {
    DishIngredient dishIngredient = DishIngredientMapper.mapDishIngredientRequestToDishIngredient(dishIngredientRequest);
    DishIngredient createdDishIngredient = this.dishIngredientRepository.save(dishIngredient);

    DishIngredientResponse dishIngredientResponse = DishIngredientMapper
      .mapDishIngredientToDishIngredientResponse(createdDishIngredient);

    return dishIngredientResponse;
  }

  @Override
  public DishIngredientResponse update(DishIngredientRequest dishIngredientRequest) {
    DishIngredient dishIngredient = DishIngredientMapper.mapDishIngredientRequestToDishIngredient(dishIngredientRequest);
    DishIngredient updatedDishIngredient = this.dishIngredientRepository.save(dishIngredient);

    DishIngredientResponse dishIngredientResponse = DishIngredientMapper
      .mapDishIngredientToDishIngredientResponse(updatedDishIngredient);

    return dishIngredientResponse;
  }

  @Override
  public void delete(Long id) {
    this.dishIngredientRepository.deleteById(id);
  }
}

