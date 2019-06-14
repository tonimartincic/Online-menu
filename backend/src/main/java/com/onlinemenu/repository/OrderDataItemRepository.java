package com.onlinemenu.repository;

import com.onlinemenu.domain.orderitem.OrderDataItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDataItemRepository extends JpaRepository<OrderDataItem, Long> {
}
