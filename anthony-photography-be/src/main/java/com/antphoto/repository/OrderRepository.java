package com.antphoto.repository;

import com.antphoto.model.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserId(Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO order_photo(order_id, photo_id) VALUES(:orderId, :photoId) ", nativeQuery = true)
    void addIdsToOrderPhoto(@Param("photoId") Integer photoId, @Param("orderId") Integer orderId);


}
