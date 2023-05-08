package com.devsuperior.empdep.repositories;

import com.devsuperior.empdep.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dm
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
}
