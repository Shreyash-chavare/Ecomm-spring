package com.project.Ecomm.repo;

import com.project.Ecomm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
