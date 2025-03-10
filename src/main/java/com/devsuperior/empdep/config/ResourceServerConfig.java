package com.devsuperior.empdep.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{
    private static final String ROLE_OPERATOR = "OPERATOR";
    private static final String ROLE_ADMIN    = "ADMIN";

    private static final String[] PUBLIC = { "/oauth/token", "/h2-console/**" };

    private static final String[] OPERATOR_GET = { "/departments/**", "/employees/**" };

    @Autowired
    private Environment env;

    @Autowired
    private JwtTokenStore tokenStore;

    /**
     * configure
     *
     * @param resources ResourceServerSecurityConfigurer
     * @throws Exception
     */
    @Override
    public void configure( ResourceServerSecurityConfigurer resources ) throws Exception
    {
        resources.tokenStore( tokenStore );
    }

    /**
     * configure
     *
     * @param http HttpSecurity
     * @throws Exception
     */
    @Override
    public void configure( HttpSecurity http ) throws Exception
    {
        // liberar h2 para testes de desenvolvimento
        if ( Arrays.asList( env.getActiveProfiles() ).contains( "test" ) )
        {
            http.headers().frameOptions().disable();
        }

        http.authorizeRequests().antMatchers( PUBLIC ).permitAll()
                                .antMatchers( HttpMethod.GET, OPERATOR_GET ).hasAnyRole( ROLE_OPERATOR, ROLE_ADMIN )
                                .anyRequest().hasAnyRole( ROLE_ADMIN );
    }
}
