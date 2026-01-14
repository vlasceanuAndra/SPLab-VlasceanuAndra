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

    // Asta ruleaza automat cand porneste aplicatia!
    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return (args) -> {
            // Salvam cateva produse in baza de date H2
            repository.save(new Product("Laptop Gaming", 4500.0));
            repository.save(new Product("Mouse Wireless", 120.50));
            repository.save(new Product("Tastatura Mecanica", 350.0));

            System.out.println("--- DATE DE TEST AU FOST INCARCATE ---");
        };
    }
}