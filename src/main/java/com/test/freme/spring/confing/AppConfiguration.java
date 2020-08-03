/**
 * 
 */
package com.test.freme.spring.confing;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.test.freme.spring.lang.Language;
import com.test.freme.spring.lang.impl.Vietnamese;

/**
 * @author bilonjea
 *
 */

@Configuration
@ComponentScan({"com.test.freme.spring"})
public class AppConfiguration {
	

    @Bean(name ="language")
    public Language getLanguage() {
 
        return new Vietnamese();
    }
    
    
    public DriverManagerDataSource provideSource() {
        DriverManagerDataSource dataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();
        //this.dataSource = dataSource;
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("testuser");
        dataSource.setPassword("RjqpoN5oLmiD7nEJ");
        dataSource.setUrl("jdbc:mysql://localhost:3306/feedback?useSSL=false&serverTimezone=UTC");
        return dataSource;
    }

    @Bean(name = "applicationJdbcTemplate")
    public JdbcTemplate applicationDataConnection(){
        return new JdbcTemplate(provideSource());
    }

}
