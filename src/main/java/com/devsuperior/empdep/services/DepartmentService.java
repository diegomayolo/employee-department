package com.devsuperior.empdep.services;

import com.devsuperior.empdep.dto.DepartmentDTO;
import com.devsuperior.empdep.entities.Department;
import com.devsuperior.empdep.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author dm
 */
@Service
public class DepartmentService
{
    @Autowired
    DepartmentRepository repository;

    /**
     * findAll
     *
     * @return List<DepartmentDTO>
     */
    public List<DepartmentDTO> findAll()
    {
        List<Department> departments = repository.findAll( Sort.by( "name" ) );

        return departments.stream().map( d -> new DepartmentDTO( d ) ).collect( Collectors.toList() );
    }
}
