package com.onlinemenu.domain.ingredient;

import com.onlinemenu.domain.dishingredient.DishIngredient;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "ingredient")
  private List<DishIngredient> dishIngredients;
}
