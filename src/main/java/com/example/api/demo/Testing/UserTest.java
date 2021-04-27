package com.example.api.demo.Testing;

import com.example.api.demo.Models.Utilisateur;
import com.example.api.demo.Repository.UtilisateurRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = "spring.profiles.active=test")
@DataJpaTest
public class UserTest {
    @Autowired
    private UtilisateurRepository entityManager;
    @Test
    public void testMe() {
        System.out.println("Hello World!");
    }
    @Test
    @Rollback
    public void testCreateUsers() {
        Utilisateur saveUsers = entityManager.save(new Utilisateur("nisrine", "amine", "cahimae@gmail.com"));
//Et j’utilise assertThat () méthode de la bibliothèque AssertJ pour plus de lisibilité que d’utiliser les méthodes d’affirmation de JUnit
        assertThat(saveUsers.getId()).isGreaterThan(0);
    }

    @Test
    public void testListProducts() {
        List<Utilisateur> Utilisateurs = entityManager.findAll();
        assertThat(Utilisateurs).size().isGreaterThan(0);
    }

}