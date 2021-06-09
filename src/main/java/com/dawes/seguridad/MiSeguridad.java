package com.dawes.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dawes.serviciosImpl.ServicioUsuarioImpl;

@Configuration
@EnableWebSecurity
public class MiSeguridad extends WebSecurityConfigurerAdapter {
	
	@Autowired
	ServicioUsuarioImpl sui;
	
	@Bean
	public BCryptPasswordEncoder BCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public String encripta(String password) {
		return BCryptPasswordEncoder().encode(password);
	}
	
	// Se programa la autentificación
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("usuario").password(encripta("temporal")).roles("REGISTRADO");
		auth.inMemoryAuthentication().withUser("administrador").password(encripta("temporal")).roles("ADMIN");
	}
	
	// Programar la autorización
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/insertarUsuario/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/insertarUsuario/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/insertarUsuario/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/submitUsuario/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/submitProducto/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/insertarProducto/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/modificarProducto/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/registrado/**").hasAnyRole("REGISTRADO","ADMIN");
		http.formLogin().loginPage("/login");
		http.exceptionHandling().accessDeniedPage("/error403");
		http.logout().logoutSuccessUrl("/index");
		http.csrf().disable();
	}
}

