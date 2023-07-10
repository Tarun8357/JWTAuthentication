package com.unoveo.security;


import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
@EnableAutoConfiguration
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
        System.out.println("In data source------------");
        return DataSourceBuilder
                .create()
                .username("root")
                .password("root")
                .url("jdbc:mariadb://localhost:3306/testjwt?createDatabaseIfNotExist=true")
                .driverClassName("org.mariadb.jdbc.Driver")
                .build();
    }

}