package org.example;

import org.example.difexamples.ClientComponent;
import org.example.difexamples.SingletonComponent;
import org.example.difexamples.TransientComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MySpringApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(MySpringApplication.class, args);

        TransientComponent t1 = context.getBean(TransientComponent.class);
        t1.operation();
        TransientComponent t2 = context.getBean(TransientComponent.class);
        t2.operation();

        SingletonComponent s1 = context.getBean(SingletonComponent.class);
        s1.operation();
        SingletonComponent s2 = context.getBean(SingletonComponent.class);
        s2.operation();

        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();
    }
}
