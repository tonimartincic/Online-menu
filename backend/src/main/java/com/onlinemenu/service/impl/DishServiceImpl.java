package com.onlinemenu.service.impl;

import com.onlinemenu.domain.dish.Dish;
import com.onlinemenu.domain.dish.DishRequest;
import com.onlinemenu.domain.dish.DishResponse;
import com.onlinemenu.mappers.DishMapper;
import com.onlinemenu.repository.DishRepository;
import com.onlinemenu.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DishServiceImpl implements DishService {

  private DishRepository dishRepository;

  @Autowired
  public DishServiceImpl(DishRepository dishRepository) {
    this.dishRepository = dishRepository;
  }

  @Override
  public List<DishResponse> getAll() {
    List<Dish> dishes = this.dishRepository.findAll();

    List<DishResponse> dishResponses = DishMapper.mapDishesToDishResponses(dishes);
    return dishResponses;
  }

  @Override
  public DishResponse get(Long id) {
    Dish dish = this.dishRepository.getOne(id);

    DishResponse dishResponse = DishMapper.mapDishToDishResponse(dish);
    return dishResponse;
  }

  @Override
  public DishResponse create(DishRequest dishRequest) {
    Dish existingDish = dishRepository.findByName(dishRequest.getName());
    if (existingDish != null) {
      throw new IllegalArgumentException("Dish with given name already exists.");
    }

    Dish dish = DishMapper.mapDishRequestToDish(dishRequest);
    Dish createdDish = this.dishRepository.save(dish);

    DishResponse dishResponse = DishMapper.mapDishToDishResponse(createdDish);
    return dishResponse;
  }

  @Override
  public DishResponse update(DishRequest dishRequest) {
    Dish existingDish = dishRepository.findByName(dishRequest.getName());
    if (existingDish != null && !Objects.equals(existingDish.getId(), dishRequest.getId())) {
      throw new IllegalArgumentException("Dish with given name already exists.");
    }

    Dish dish = DishMapper.mapDishRequestToDish(dishRequest);
    Dish updatedDish = this.dishRepository.save(dish);

    DishResponse dishResponse = DishMapper.mapDishToDishResponse(updatedDish);
    return dishResponse;
  }

  @Override
  public void delete(Long id) {
    this.dishRepository.deleteById(id);
  }
}
