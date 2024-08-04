package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.model.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {

}
