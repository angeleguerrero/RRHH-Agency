package net.ag.empleos.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource) 
		.usersByUsernameQuery("select username , password, estatus from usuarios where username=?")
		.authoritiesByUsernameQuery("select u.username, p.perfil from usuarioperfil up " +
		"inner join usuarios u on u.id=up.idUsuario " +
		"inner join perfiles p on p.id=up.idPerfil " +
		"where u.username= ?");
	}
	
	
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		//recursos estaticos que no requieren autorizacion
		.antMatchers(
		"/bootstrap/**",
		"/images/**",
		"/tinymce/**",
		"/logos/**").permitAll()
		
		//Vistas publicas que no requieren autenticacon
		.antMatchers(
				"/",
				"/singup",
				"/buscarvacante",
				"/viewe"
				).permitAll()
		
		
		
//		Permisos a modulos por roles
		.antMatchers("/vacantes/**").hasAnyAuthority("SUPERVISOR", "ADMINISTRADOR")
		.antMatchers("/categorias/**").hasAnyAuthority("SUPERVISOR", "ADMINISTRADOR")
		.antMatchers("/usuarios/**").hasAnyAuthority("ADMINISTRADOR")
		
		
		//Todas las demas URL de la aplicacion requieren autenticacion
		.anyRequest().authenticated()
		.and().formLogin().permitAll();

	}
	
	
	
	/* DEFAULT CONFIG
	protected void configure (AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	*/
	
//	Encriptar contraseñas
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	
	
}
