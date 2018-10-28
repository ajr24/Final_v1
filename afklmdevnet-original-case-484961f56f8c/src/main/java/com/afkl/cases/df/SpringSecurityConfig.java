package com.afkl.cases.df;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


	   @Override
	    public void configure( final WebSecurity web ) throws Exception {
	        web.ignoring().antMatchers( "/**");
	    }
	 
	    @Override
	    protected void configure( final HttpSecurity http ) throws Exception {
	        super.configure( http );
	    }
}
