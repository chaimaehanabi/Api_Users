package com.example.api.demo;

import com.example.api.demo.Models.Utilisateur;
import com.example.api.demo.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private UtilisateurRepository entityManager;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        entityManager.save(new Utilisateur("chaimae", "hanabi", "cahimae@gmail.com"));
        entityManager.save(new Utilisateur("safae", "tazi", "safae@gmail.com"));
        entityManager.save(new Utilisateur("sara", "barrada", "safae@gmail.com"));
        entityManager.findAll().forEach(c -> {
            System.out.println(c.toString());
        });
    }
}
