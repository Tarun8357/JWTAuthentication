package com.unoveo.security;


import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Spring Data Configuration.
 *
 * @author Rob Winch
 */
@Configuration
public class DataSourceConfig {

//    @Bean
//    public DataSource dataSource() {
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        return builder.setType(EmbeddedDatabaseType.HSQL)
//                .addScript("classpath:org/springframework/security/core/userdetails/jdbc/users.ddl").build();
//    }

    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("root")
                .password("root")
                .url("jdbc:mariadb://localhost:3306/testjwt")
                .driverClassName("org.mariadb.jdbc.Driver")
                .build();
    }

}