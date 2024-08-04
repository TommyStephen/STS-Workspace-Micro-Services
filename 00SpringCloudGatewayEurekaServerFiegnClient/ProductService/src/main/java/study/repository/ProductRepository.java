package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
