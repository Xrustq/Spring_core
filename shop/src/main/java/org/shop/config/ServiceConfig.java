package org.shop.config;

import org.shop.api.*;
import org.shop.api.impl.*;
import org.shop.repository.ItemRepository;
import org.shop.repository.ProductRepository;
import org.shop.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProposalRepository proposalRepository;


    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl();
    }

    @Bean
    public SellerService sellerService() {
        return new SellerServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public ItemService itemService() {
        return new ItemServiceImpl(itemRepository);
    }


    @Bean
    public ProductService productService() {
        return new ProductServiceImpl(productRepository);
    }

    @Bean
    public ProposalService proposalService() {
        return new ProposalServiceImpl(proposalRepository);
    }


}