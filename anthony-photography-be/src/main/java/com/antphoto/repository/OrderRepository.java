package com.antphoto.repository;

import com.antphoto.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
//    List<Order> findAllByUserId(Integer id) throws Exception;
}
