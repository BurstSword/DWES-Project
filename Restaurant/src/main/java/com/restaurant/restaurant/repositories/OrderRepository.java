package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.entities.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * Order repository to operate with Order table
 */
@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
}
