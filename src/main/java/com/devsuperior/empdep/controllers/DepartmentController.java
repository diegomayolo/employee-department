package com.devsuperior.empdep.controllers;

import com.devsuperior.empdep.dto.DepartmentDTO;
import com.devsuperior.empdep.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author dm
 */
@RestController
@RequestMapping( value =  "/departments" )
public class DepartmentController
{
    @Autowired
    private DepartmentService service;

    /**
     * findAll
     *
     * @return ResponseEntity<List<DepartmentDTO>>
     */
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll()
    {
        List<DepartmentDTO> departments = service.findAll();

        return ResponseEntity.ok().body( departments );
    }
}