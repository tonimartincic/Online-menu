package com.onlinemenu.domain.dish;

import lombok.Data;

@Data
public class DishRequest {

  private Long id;

  private String name;

  private Double price;
}
