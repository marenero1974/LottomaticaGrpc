package it.lottomatica.configuration;

import it.lottomatica.service.CustomMongoService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LottomaticaConfig {



    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

    @Bean
    public CustomMongoService externalService() {
        return new CustomMongoService("mongodb://localhost:27017", "testdb", "customCollection");
    }

}
