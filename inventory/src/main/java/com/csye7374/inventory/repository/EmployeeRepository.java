package com.csye7374.inventory.repository;

import com.csye7374.inventory.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//C
//	Employee save(Employee emp);
	//R
//	public List<Employee> findAll();
	
	//R by ID
	Optional<Employee> findById(int id);
	
	//U
//	void update(Employee emp);
	//D
	//void delete(Employee emp);

	Optional<Employee> findByUsernameAndPassword(String username, String password);
	
	Optional<Employee> findByUsername(String username);
}
