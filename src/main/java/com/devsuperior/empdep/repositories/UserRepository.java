package com.devsuperior.empdep.repositories;

import com.devsuperior.empdep.entities.Department;
import com.devsuperior.empdep.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dm
 */
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByEmail( String email );
}
