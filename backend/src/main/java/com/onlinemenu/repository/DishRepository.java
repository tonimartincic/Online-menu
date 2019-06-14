package com.onlinemenu.repository;

import com.onlinemenu.domain.dish.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

  Dish findByName(String name);
}
