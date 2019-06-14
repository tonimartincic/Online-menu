package com.onlinemenu.service.impl;

import com.onlinemenu.domain.order.OrderData;
import com.onlinemenu.domain.orderitem.OrderDataItem;
import com.onlinemenu.domain.orderitem.OrderDataItemRequest;
import com.onlinemenu.domain.orderitem.OrderDataItemResponse;
import com.onlinemenu.mappers.OrderItemMapper;
import com.onlinemenu.repository.OrderDataItemRepository;
import com.onlinemenu.service.OrderDataItemService;
import com.onlinemenu.service.OrderDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDataItemServiceImpl implements OrderDataItemService {

  private OrderDataItemRepository orderItemRepository;

  private OrderDataService orderDataService;

  @Autowired
  public OrderDataItemServiceImpl(
    OrderDataItemRepository orderItemRepository,
    OrderDataService orderDataService) {
    this.orderItemRepository = orderItemRepository;
    this.orderDataService = orderDataService;
  }

  @Override
  public List<OrderDataItemResponse> getAll() {
    List<OrderDataItem> orderItems = this.orderItemRepository.findAll();

    List<OrderDataItemResponse> orderItemResponses = OrderItemMapper.mapOrderItemsToOrderItemResponses(orderItems);
    return orderItemResponses;
  }

  @Override
  public OrderDataItemResponse get(Long id) {
    OrderDataItem orderItem = this.orderItemRepository.getOne(id);

    OrderDataItemResponse orderItemResponse = OrderItemMapper.mapOrderItemToOrderItemResponse(orderItem);
    return orderItemResponse;
  }

  @Override
  public OrderDataItemResponse create(OrderDataItemRequest orderItemRequest) {
    OrderDataItem orderItem = OrderItemMapper.mapOrderItemRequestToOrderItem(orderItemRequest);
    OrderDataItem createdOrderItem = this.orderItemRepository.save(orderItem);

    this.orderDataService.recalculateOrderData(createdOrderItem.getOrderId());

    OrderDataItemResponse orderItemResponse = OrderItemMapper.mapOrderItemToOrderItemResponse(createdOrderItem);
    return orderItemResponse;
  }

  @Override
  public OrderDataItemResponse update(OrderDataItemRequest orderItemRequest) {
    OrderDataItem orderItem = OrderItemMapper.mapOrderItemRequestToOrderItem(orderItemRequest);
    OrderDataItem updatedOrderItem = this.orderItemRepository.save(orderItem);

    this.orderDataService.recalculateOrderData(updatedOrderItem.getOrderId());

    OrderDataItemResponse orderItemResponse = OrderItemMapper.mapOrderItemToOrderItemResponse(updatedOrderItem);
    return orderItemResponse;
  }

  @Override
  public void delete(Long id) {
    OrderData orderData = this.orderItemRepository.getOne(id).getOrder();

    this.orderItemRepository.deleteById(id);
    this.orderDataService.recalculateOrderData(orderData.getId());
  }
}
