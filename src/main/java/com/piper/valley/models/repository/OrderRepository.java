package com.piper.valley.models.repository;

import com.piper.valley.models.domain.Order;
import com.piper.valley.models.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOneById(Long id);
    Integer countOrdersByUser_IdAndOrderStatus(Long id, OrderStatus orderStatus);
    List<Order> findAllByStoreProduct_Store_IdAndProcessedDateAfterAndOrderStatusIn(Long Id, Date date, List<OrderStatus> orderStatuses);
    List<Order> findAllByUser_IdAndOrderStatus(Long id, OrderStatus orderStatus);
    List<Order> findAllByUser_IdAndOrderStatusOrderByProcessedDateDesc(Long id, OrderStatus orderStatus);
    List<Order> findAllByOrderStatus(OrderStatus orderStatus);
}
