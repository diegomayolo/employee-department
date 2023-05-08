package com.devsuperior.empdep.controllers;

import com.devsuperior.empdep.dto.EmployeeDTO;
import com.devsuperior.empdep.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 *
 * @author dm
 */
@RestController
@RequestMapping( value =  "/employees" )
public class EmployeeController
{
    @Autowired
    private EmployeeService service;

    /**
     * findAll
     *
     * @return ResponseEntity<Page<EmployeeDTO>>
     */
    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAll( Pageable pageable )
    {
        PageRequest pageRequest = PageRequest.of( pageable.getPageNumber(), pageable.getPageSize(), Sort.by( "name" ) );

        Page<EmployeeDTO> page = service.findAll( pageRequest );

        return ResponseEntity.ok().body( page );
    }

    /**
     * insert
     *
     * @param dto CategoryDTO
     * @return ResponseEntity<CategoryDTO>
     */
    @PostMapping
    public ResponseEntity<EmployeeDTO> insert( @Valid @RequestBody EmployeeDTO dto )
    {
        dto = service.insert( dto );

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path( "/{id}" )
                                                                  .buildAndExpand( dto.getId() )
                                                                  .toUri();

        return ResponseEntity.created( uri ).body( dto );
    }
}