package com.onlinemenu.service;

import com.onlinemenu.domain.dish.DishRequest;
import com.onlinemenu.domain.dish.DishResponse;

import java.util.List;

public interface DishService {
  
  List<DishResponse> getAll();

  DishResponse get(Long id);

  DishResponse create(DishRequest dishRequest);

  DishResponse update(DishRequest dishRequest);

  void delete(Long id);
}
