package com.devsuperior.empdep.dto;

import com.devsuperior.empdep.entities.Department;

import java.io.Serializable;

public class DepartmentDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    /**
     * DepartmentDTO
     */
    public DepartmentDTO() {}

    /**
     * DepartmentDTO
     *
     * @param id Long
     * @param name String
     */
    public DepartmentDTO(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    /**
     * DepartmentDTO
     *
     * @param department Department
     */
    public DepartmentDTO( Department department )
    {
        this.id = department.getId();
        this.name = department.getName();
    }

    /**
     * getId
     *
     * @return Long
     */
    public Long getId()
    {
        return id;
    }

    /**
     * setId
     *
     * @param id Long
     */
    public void setId( Long id )
    {
        this.id = id;
    }

    /**
     * getName
     *
     * @return String
     */
    public String getName()
    {
        return name;
    }

    /**
     * setName
     *
     * @param name String
     */
    public void setName( String name )
    {
        this.name = name;
    }
}
