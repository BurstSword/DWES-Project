package com.restaurant.restaurant.repositories;

import com.restaurant.restaurant.entities.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

    Boolean existsAdminByMail(String mail);

    Optional<Admin> findByMail(String mail);
}
