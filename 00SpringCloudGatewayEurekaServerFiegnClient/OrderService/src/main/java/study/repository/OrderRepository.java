package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
