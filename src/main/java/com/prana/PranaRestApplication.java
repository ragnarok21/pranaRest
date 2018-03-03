package com.prana;

import com.prana.domain.Cliente;
import com.prana.domain.CustomClientDetails;
import com.prana.domain.Roles;
import com.prana.repository.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PranaRestApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PranaRestApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(PranaRestApplication.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, final ClienteDao clienteDao) throws Exception {

		if(clienteDao.count() == 0) {
			Cliente cliente = new Cliente();
			cliente.setUsername("user");
			cliente.setPassword("user");
			cliente.setRoles(Arrays.asList(new Roles("USER"), new Roles("ADMIN")));
			clienteDao.save(cliente);
		}
		builder.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return new CustomClientDetails(clienteDao.getClienteByUsername(username));
			}
		});
	}
}
