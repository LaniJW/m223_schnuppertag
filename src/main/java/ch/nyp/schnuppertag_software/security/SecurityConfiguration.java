package ch.nyp.schnuppertag_software.security;

import ch.nyp.schnuppertag_software.webcontext.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Properties;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	// field injection bcause this class doesn't need to be tested
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder pwEncoder;

	@Autowired
	private Properties properties;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// registers the UserDetailsService (used to loadByUsername) and the password
		// encoder to be used
		auth.userDetailsService(userService).passwordEncoder(pwEncoder);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		properties = new Properties();
		properties.load(getClass().getResourceAsStream("/application.properties"));

		// create filters for later use
		var authenticationReqMatcher = new AntPathRequestMatcher("/login", "POST");
		var authenticationFilter =
				new JWTAuthenticationFilter(authenticationManager(), properties, authenticationReqMatcher);

		var authorizationFilter =
				new JWTAuthorizationFilter(userService, properties);

		// configure security
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/addresses", "/locations", "/specializations", "/trainers", "/trainees", "/trialdays", "/swagger-ui.html")
				.permitAll()
				.anyRequest().authenticated().and()
				.addFilterAfter(
						authenticationFilter,
						UsernamePasswordAuthenticationFilter.class)
				.addFilterAfter(
						authorizationFilter,
						UsernamePasswordAuthenticationFilter.class)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
