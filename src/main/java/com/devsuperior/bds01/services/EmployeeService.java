package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dm
 */
@Service
public class EmployeeService
{
    @Autowired
    EmployeeRepository repository;

    /**
     * findAll
     *
     * @return List<DepartmentDTO>
     */
    @Transactional( readOnly = true )
    public Page<EmployeeDTO> findAll( Pageable pageable )
    {
        Page<Employee> page = repository.findAll( pageable );

        return page.map( e -> new EmployeeDTO( e ) );
    }

    /**
     * insert
     *
     * @param dto EmployeeDTO
     * @return EmployeeDTO
     */
    @Transactional
    public EmployeeDTO insert( EmployeeDTO dto )
    {
        Employee employee = new Employee();
        employee.setName( dto.getName() );
        employee.setEmail( dto.getEmail() );
        employee.setDepartment( new Department( dto.getDepartmentId(), null ) );

        employee = repository.save( employee );

        return new EmployeeDTO( employee );
    }
}
