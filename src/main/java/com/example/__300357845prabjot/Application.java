package com.example.__300357845prabjot;

import com.example.__300357845prabjot.entity.Salesman;
import com.example.__300357845prabjot.repositories.salesmanRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(salesmanRepositories sr) {
        return args ->{

            sr.save(new Salesman(1,2900,new Date(), "Washing Machine", "Ammer"));
            sr.save(new Salesman(2,2900,new Date(), "Washing Machine", "Ammer"));
            sr.save(new Salesman(3,2900,new Date(), "Washing Machine", "Ammer"));
            sr.save(new Salesman(4,2900,new Date(), "Washing Machine", "Ammer"));

            sr.findAll().forEach(p->{
                System.out.println(p.getName());
            });
        };


        }

    }
