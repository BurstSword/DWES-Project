package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.entities.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Categories, Integer> {
}
