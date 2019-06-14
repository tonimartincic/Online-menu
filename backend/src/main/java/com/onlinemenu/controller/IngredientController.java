package com.onlinemenu.controller;

import com.onlinemenu.domain.ingredient.IngredientRequest;
import com.onlinemenu.domain.ingredient.IngredientResponse;
import com.onlinemenu.service.IngredientService;
import org.apache.commons.lang.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

  private final IngredientService ingredientService;

  @Autowired
  public IngredientController(final IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @GetMapping("/api/ingredients")
  public List<IngredientResponse> getAll() {
    return this.ingredientService.getAll();
  }

  @GetMapping("/api/ingredients/{id}")
  public IngredientResponse get(@PathVariable final Long id) {
    return this.ingredientService.get(id);
  }

  @PostMapping("/api/ingredients")
  public IngredientResponse create(@RequestBody final IngredientRequest ingredientRequest) {
    if (ingredientRequest == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.ingredientService.create(ingredientRequest);
  }

  @PutMapping("/api/ingredients")
  public IngredientResponse update(@RequestBody final IngredientRequest ingredientRequest) {
    if (ingredientRequest == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.ingredientService.update(ingredientRequest);
  }

  @DeleteMapping("/api/ingredients/{id}")
  public void delete(@PathVariable final Long id) {
    this.ingredientService.delete(id);
  }
}
