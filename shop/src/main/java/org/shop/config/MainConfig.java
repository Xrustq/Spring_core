package org.shop.config;


import org.shop.aspect.LoggingAspect;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.shop")
@Import({InitializerConfig.class,
        ServiceConfig.class,
        RepositoryConfig.class})

public class MainConfig {

//    @Bean
//    public LoggingAspect aspect() {
//        return new LoggingAspect();
//    }
}
