package com.borrowbook.config;

import com.borrowbook.logger.BookLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookLogger createBookLogger(){
        return new BookLogger();
    }
}
