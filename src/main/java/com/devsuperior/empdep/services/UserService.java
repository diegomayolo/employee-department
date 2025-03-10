package com.devsuperior.empdep.services;

import com.devsuperior.empdep.entities.User;
import com.devsuperior.empdep.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService
{
    private static Logger logger = LoggerFactory.getLogger( UserService.class );

    @Autowired
    private UserRepository userRepository;

    /**
     * loadUserByUsername
     *
     * @param username String
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
    {
        User user = userRepository.findByEmail( username );

        if ( user == null )
        {
            logger.error( "User not found: " + username );
            throw new UsernameNotFoundException( "Email not found" );
        }

        logger.info( "User found: " + username );
        return user;
    }
}
