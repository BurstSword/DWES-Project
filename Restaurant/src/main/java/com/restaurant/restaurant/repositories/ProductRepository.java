package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.entities.Orders;
import com.restaurant.restaurant.entities.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Products, Integer> {
}
