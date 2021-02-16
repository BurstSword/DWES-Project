package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.entities.Orders;
import com.restaurant.restaurant.entities.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
/**
 * Product repository to operate with Product table
 */
@Repository
public interface ProductRepository extends CrudRepository<Products, Integer> {
    /**
     * Returns all the products inside specific orders
     * @param id orders id
     * @return Product list from orders
     */
    List<Products> findAllByIdInOrderByIdAsc(Collection<Integer> id);
}
