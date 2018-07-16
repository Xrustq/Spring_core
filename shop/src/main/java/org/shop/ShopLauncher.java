package org.shop;


import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        DataInitializer dataInitializer = context.getBean(DataInitializer.class);
        dataInitializer.initData();
        System.out.println(context.getBean(ProductService.class).getProducts());
//        System.out.println(context.getBean(UserService.class).getUsers());
    }
}
