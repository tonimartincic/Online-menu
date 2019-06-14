package com.onlinemenu.enumeration;

public enum DeliveryPriceCalculationMode {

  FIXED_PRICE(1L),
  TOTAL_PRICE_PERCENTAGE(2L);

  private final Long id;

  DeliveryPriceCalculationMode(final Long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }
}
