package com.coord.main;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.coord.dao"})
@EntityScan(basePackages = {"com.coord.model"})
@ComponentScan("com.coord")
public class CoordenadasApplication  {
    
    public static void main(String[] args) throws SQLException, IOException {

        SpringApplication.run(CoordenadasApplication.class, args);
    
    }
    
}
