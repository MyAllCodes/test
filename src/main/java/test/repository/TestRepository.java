package test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import test.entity.Students;

public interface TestRepository extends JpaRepository<Students, Long>{
	public List<Students> findAll();
	public Students save(Students s);
}
