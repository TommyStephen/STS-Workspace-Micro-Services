package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
