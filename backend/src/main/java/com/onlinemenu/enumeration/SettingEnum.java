package com.onlinemenu.enumeration;

public enum SettingEnum {

  DELIVERY_PRICE_CALCULATION_MODE(1L);

  private final Long id;

  SettingEnum(final Long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }
}
