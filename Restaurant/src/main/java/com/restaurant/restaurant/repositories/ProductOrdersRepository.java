package com.restaurant.restaurant.repositories;


import com.restaurant.restaurant.entities.ProductOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrdersRepository extends CrudRepository<ProductOrders, Integer> {
}
