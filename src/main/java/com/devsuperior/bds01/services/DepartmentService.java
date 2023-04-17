package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;
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
