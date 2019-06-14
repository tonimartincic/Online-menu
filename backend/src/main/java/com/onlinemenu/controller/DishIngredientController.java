package com.onlinemenu.controller;

import com.onlinemenu.domain.dishingredient.DishIngredientRequest;
import com.onlinemenu.domain.dishingredient.DishIngredientResponse;
import com.onlinemenu.service.DishIngredientService;
import org.apache.commons.lang.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishIngredientController {

  private final DishIngredientService dishIngredientService;

  @Autowired
  public DishIngredientController(final DishIngredientService dishIngredientService) {
    this.dishIngredientService = dishIngredientService;
  }

  @GetMapping("/api/dish-ingredients")
  public List<DishIngredientResponse> getAll() {
    return this.dishIngredientService.getAll();
  }

  @GetMapping("/api/dish-ingredients/{id}")
  public DishIngredientResponse get(@PathVariable final Long id) {
    return this.dishIngredientService.get(id);
  }

  @PostMapping("/api/dish-ingredients")
  public DishIngredientResponse create(@RequestBody final DishIngredientRequest dishIngredientRequest) {
    if (dishIngredientRequest == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.dishIngredientService.create(dishIngredientRequest);
  }

  @PutMapping("/api/dish-ingredients")
  public DishIngredientResponse update(@RequestBody final DishIngredientRequest dishIngredientRequest) {
    if (dishIngredientRequest == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.dishIngredientService.update(dishIngredientRequest);
  }

  @DeleteMapping("/api/dish-ingredients/{id}")
  public void delete(@PathVariable final Long id) {
    this.dishIngredientService.delete(id);
  }
}
