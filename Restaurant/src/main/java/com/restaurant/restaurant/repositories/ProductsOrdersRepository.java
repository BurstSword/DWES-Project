package com.restaurant.restaurant.repositories;


import com.restaurant.restaurant.entities.Orders;
import com.restaurant.restaurant.entities.ProductsOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface ProductsOrdersRepository extends CrudRepository<ProductsOrders, Integer> {
    List<ProductsOrders> findAllByOrders_Id(int id);
}
