package com.onlinemenu.controller;

import com.onlinemenu.domain.dish.DishRequest;
import com.onlinemenu.domain.dish.DishResponse;
import com.onlinemenu.service.DishService;
import org.apache.commons.lang.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {

  private final DishService dishService;

  @Autowired
  public DishController(final DishService dishService) {
    this.dishService = dishService;
  }

  @GetMapping("/api/dishes")
  public List<DishResponse> getAll() {
    return this.dishService.getAll();
  }

  @GetMapping("/api/dishes/{id}")
  public DishResponse get(@PathVariable final Long id) {
    return this.dishService.get(id);
  }

  @PostMapping("/api/dishes")
  public DishResponse create(@RequestBody final DishRequest dishRequest) {
    if (dishRequest == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.dishService.create(dishRequest);
  }

  @PutMapping("/api/dishes")
  public DishResponse update(@RequestBody final DishRequest dishRequest) {
    if (dishRequest == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.dishService.update(dishRequest);
  }

  @DeleteMapping("/api/dishes/{id}")
  public void delete(@PathVariable final Long id) {
    this.dishService.delete(id);
  }
}
