package org.shop.config;

import org.shop.annotation.InjectRandomLong;
import org.shop.repository.*;
import org.shop.repository.factory.UserRepositoryFactory;
import org.shop.repository.map.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

//@Component
@Configuration
@PropertySource("classpath:config.properties")
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RepositoryConfig {

//    @Value("${initialSequence}")
    @InjectRandomLong(min = 100L, max = 200L)
    private long sequence;

    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ItemRepository itemRepository() {
        return new ItemMapRepository();
    }

    @Bean
    public OrderRepository orderRepository() {
        OrderMapRepository orderMapRepository = new OrderMapRepository();
        orderMapRepository.setSequence(sequence);
        System.out.println(sequence);
        return orderMapRepository;
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductMapRepository();
    }

    @Bean
    public ProposalRepository proposalRepository() {
        return new ProposalMapRepository();
    }

    @Bean
    public SellerRepository sellerRepository() {
        return new SellerMapRepository();
    }

    @Bean
    public UserRepositoryFactory userRepositoryFactory() {
        return new UserRepositoryFactory();
    }

    @Bean
    public UserRepository userRepository() {
        return userRepositoryFactory().createUserRepository();
    }
}
