package study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import study.entity.Child;

public interface ChildRepository extends JpaRepository<Child, Long> {

	List<Child> findByParentId(long parentId);
}
