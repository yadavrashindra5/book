package com.book.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    /*
    * Now spring IOC container creates the bean automatically
    * */
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
