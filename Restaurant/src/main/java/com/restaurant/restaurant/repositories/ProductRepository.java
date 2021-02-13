package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.entities.Orders;
import com.restaurant.restaurant.entities.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Products, Integer> {
    List<Products> findAllByIdInOrderByIdAsc(Collection<Integer> id);
}
