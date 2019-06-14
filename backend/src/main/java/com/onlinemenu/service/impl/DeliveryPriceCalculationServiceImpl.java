package com.onlinemenu.service.impl;

import com.onlinemenu.domain.order.OrderData;
import com.onlinemenu.domain.setting.Setting;
import com.onlinemenu.enumeration.DeliveryPriceCalculationMode;
import com.onlinemenu.enumeration.SettingEnum;
import com.onlinemenu.service.DeliveryPriceCalculationService;
import com.onlinemenu.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DeliveryPriceCalculationServiceImpl implements DeliveryPriceCalculationService {

  private static final Double FIXED_DELIVERY_PRICE = 5.0;

  private static final Double TOTAL_PRICE_PERCENTAGE_DELIVERY_PRICE = 0.1;

  private SettingService settingService;

  @Autowired
  public DeliveryPriceCalculationServiceImpl(SettingService settingService) {
    this.settingService = settingService;
  }

  @Override
  public void calculateAndSetDeliveryPrice(OrderData order) {
    Setting deliveryPriceCalculationMode = settingService.get(SettingEnum.DELIVERY_PRICE_CALCULATION_MODE.getId());
    Long currentModeId = deliveryPriceCalculationMode.getSettingValue();

    Double deliveryPrice;
    if (Objects.equals(currentModeId, DeliveryPriceCalculationMode.FIXED_PRICE.getId())) {
      deliveryPrice = getFixedDeliveryPrice();
    } else if (Objects.equals(currentModeId, DeliveryPriceCalculationMode.TOTAL_PRICE_PERCENTAGE.getId())) {
      deliveryPrice = getTotalPricePercentageDeliveryPrice(order);
    } else {
      throw new UnsupportedOperationException("Non existing delivery price calculation mode");
    }

    order.setDeliveryPrice(deliveryPrice);
  }

  private Double getFixedDeliveryPrice() {
    return FIXED_DELIVERY_PRICE;
  }

  private Double getTotalPricePercentageDeliveryPrice(OrderData order) {
    return order.getTotalPrice() * TOTAL_PRICE_PERCENTAGE_DELIVERY_PRICE;
  }
}
