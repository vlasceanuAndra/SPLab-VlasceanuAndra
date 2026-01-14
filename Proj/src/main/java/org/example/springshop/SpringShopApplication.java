package org.example.springshop;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShopApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return (args) -> {
            repository.save(new Product("Laptop", 4500.0));
            repository.save(new Product("Mouse", 120.50));
            repository.save(new Product("Tastatura", 350.0));

            System.out.println("--- DATELE DE TEST AU FOST INCARCATE ---");
        };
    }
}