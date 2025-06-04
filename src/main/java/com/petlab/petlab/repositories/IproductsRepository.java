package com.petlab.petlab.repositories;

import com.petlab.petlab.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IproductsRepository extends JpaRepository<Products, Long> {
}
