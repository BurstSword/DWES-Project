package com.restaurant.restaurant.repositories;



import com.restaurant.restaurant.entities.ProductsOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Collection;
import java.util.List;

/**
 * ProductOrder repository to operate with ProductOrder table
 */
@Repository
public interface ProductsOrdersRepository extends CrudRepository<ProductsOrders, Integer> {
    /**
     * Returns all ProductOrders with specific orders id
     * @param id Orders id
     * @return ProductsOrders list
     */
    List<ProductsOrders> findAllByOrders_IdIn(Collection<Integer> id);


}
