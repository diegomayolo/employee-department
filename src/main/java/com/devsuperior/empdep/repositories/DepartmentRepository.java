package com.devsuperior.empdep.repositories;

import com.devsuperior.empdep.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dm
 */
public interface DepartmentRepository extends JpaRepository<Department, Long>
{
}
