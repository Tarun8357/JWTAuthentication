package com.unoveo;


import com.unoveo.controllers.AuthController;
import com.unoveo.models.ERole;
import com.unoveo.models.Role;
import com.unoveo.models.User;
import com.unoveo.repository.RoleRepository;
import com.unoveo.repository.UserRepository;
import com.unoveo.security.IndexController;
import com.unoveo.security.jwt.AuthEntryPointJwt;
import com.unoveo.security.jwt.AuthTokenFilter;
import com.unoveo.security.services.UserDetailsServiceImpl;
import com.unoveo.userservices.UserService;
import com.unoveo.userservices.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@ComponentScan("com.unoveo")
// (securedEnabled = true,
// jsr250Enabled = true,
// prePostEnabled = true) // by default
public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {
  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

//  @Override
//  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//  }
  
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       
      authProvider.setUserDetailsService(userDetailsService);
      authProvider.setPasswordEncoder(passwordEncoder());
   
      return authProvider;
  }

//  @Bean
//  @Override
//  public AuthenticationManager authenticationManagerBean() throws Exception {
//    return super.authenticationManagerBean();
//  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.cors().and().csrf().disable()
//      .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//      .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//      .antMatchers("/api/test/**").permitAll()
//      .anyRequest().authenticated();
//
//    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//  }
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> 
          auth.requestMatchers("/api/auth/**").permitAll()
              .requestMatchers("/api/test/**").permitAll()
              .anyRequest().authenticated()
        );
    
    http.authenticationProvider(authenticationProvider());

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    
    return http.build();
  }
 @Bean
  public UserRepository userRepository(){
    return new UserRepository() {
      @Override
      public Optional<User> findByUsername(String username) {
        return Optional.empty();
      }

      @Override
      public Boolean existsByUsername(String username) {
        return null;
      }

      @Override
      public Boolean existsByEmail(String email) {
        return null;
      }

      @Override
      public void flush() {

      }

      @Override
      public <S extends User> S saveAndFlush(S entity) {
        return null;
      }

      @Override
      public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
      }

      @Override
      public void deleteAllInBatch(Iterable<User> entities) {

      }

      @Override
      public void deleteAllByIdInBatch(Iterable<Long> longs) {

      }

      @Override
      public void deleteAllInBatch() {

      }

      @Override
      public User getOne(Long aLong) {
        return null;
      }

      @Override
      public User getById(Long aLong) {
        return null;
      }

      @Override
      public User getReferenceById(Long aLong) {
        return null;
      }

      @Override
      public <S extends User> List<S> findAll(Example<S> example) {
        return null;
      }

      @Override
      public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
        return null;
      }

      @Override
      public <S extends User> List<S> saveAll(Iterable<S> entities) {
        return null;
      }

      @Override
      public List<User> findAll() {
        return null;
      }

      @Override
      public List<User> findAllById(Iterable<Long> longs) {
        return null;
      }

      @Override
      public <S extends User> S save(S entity) {
        return null;
      }

      @Override
      public Optional<User> findById(Long aLong) {
        return Optional.empty();
      }

      @Override
      public boolean existsById(Long aLong) {
        return false;
      }

      @Override
      public long count() {
        return 0;
      }

      @Override
      public void deleteById(Long aLong) {

      }

      @Override
      public void delete(User entity) {

      }

      @Override
      public void deleteAllById(Iterable<? extends Long> longs) {

      }

      @Override
      public void deleteAll(Iterable<? extends User> entities) {

      }

      @Override
      public void deleteAll() {

      }

      @Override
      public List<User> findAll(Sort sort) {
        return null;
      }

      @Override
      public Page<User> findAll(Pageable pageable) {
        return null;
      }

      @Override
      public <S extends User> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
      }

      @Override
      public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
      }

      @Override
      public <S extends User> long count(Example<S> example) {
        return 0;
      }

      @Override
      public <S extends User> boolean exists(Example<S> example) {
        return false;
      }

      @Override
      public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
      }
    };
 }

 @Bean
  public RoleRepository roleRepository(){
    return new RoleRepository() {
      @Override
      public Optional<Role> findByName(ERole name) {
        return Optional.empty();
      }

      @Override
      public void flush() {

      }

      @Override
      public <S extends Role> S saveAndFlush(S entity) {
        return null;
      }

      @Override
      public <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
      }

      @Override
      public void deleteAllInBatch(Iterable<Role> entities) {

      }

      @Override
      public void deleteAllByIdInBatch(Iterable<Long> longs) {

      }

      @Override
      public void deleteAllInBatch() {

      }

      @Override
      public Role getOne(Long aLong) {
        return null;
      }

      @Override
      public Role getById(Long aLong) {
        return null;
      }

      @Override
      public Role getReferenceById(Long aLong) {
        return null;
      }

      @Override
      public <S extends Role> List<S> findAll(Example<S> example) {
        return null;
      }

      @Override
      public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
        return null;
      }

      @Override
      public <S extends Role> List<S> saveAll(Iterable<S> entities) {
        return null;
      }

      @Override
      public List<Role> findAll() {
        return null;
      }

      @Override
      public List<Role> findAllById(Iterable<Long> longs) {
        return null;
      }

      @Override
      public <S extends Role> S save(S entity) {
        return null;
      }

      @Override
      public Optional<Role> findById(Long aLong) {
        return Optional.empty();
      }

      @Override
      public boolean existsById(Long aLong) {
        return false;
      }

      @Override
      public long count() {
        return 0;
      }

      @Override
      public void deleteById(Long aLong) {

      }

      @Override
      public void delete(Role entity) {

      }

      @Override
      public void deleteAllById(Iterable<? extends Long> longs) {

      }

      @Override
      public void deleteAll(Iterable<? extends Role> entities) {

      }

      @Override
      public void deleteAll() {

      }

      @Override
      public List<Role> findAll(Sort sort) {
        return null;
      }

      @Override
      public Page<Role> findAll(Pageable pageable) {
        return null;
      }

      @Override
      public <S extends Role> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
      }

      @Override
      public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
      }

      @Override
      public <S extends Role> long count(Example<S> example) {
        return 0;
      }

      @Override
      public <S extends Role> boolean exists(Example<S> example) {
        return false;
      }

      @Override
      public <S extends Role, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
      }
    };
 }
 
 @Bean
  public IndexController indexController(){
   UserService userService = null;
    return new IndexController( userService);
 }
 @Bean
  public UserServiceImpl userServiceImpl(){
    return new UserServiceImpl();
 }
}
