package org.shop.config;

import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.common.Sellers;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class InitializerConfig {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;


    @Bean(autowire = Autowire.BY_NAME)
    public ProposalInitializer proposalInitializer() {
        return new ProposalInitializer();
    }

    @Bean
    public SellerInitializer sellerInitializer() {
        return new SellerInitializer();
    }

    @Bean
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }

    @Bean
    public ProductInitializer productInitializer() {
        return new ProductInitializer(productService);
    }

    @Bean
    public UserInitializer userInitializer() {
        return new UserInitializer(userService);
    }

    @Bean
    public Map<Long, String> sellerNames() {
        Map<Long, String> map = new HashMap<>();
        map.put(1L, Sellers.AMAZON);
        map.put(2L, Sellers.SAMSUNG);
        return map;
    }
}
