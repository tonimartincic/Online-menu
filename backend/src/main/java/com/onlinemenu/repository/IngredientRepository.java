package com.onlinemenu.repository;

import com.onlinemenu.domain.ingredient.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

  Ingredient findByName(String name);
}
