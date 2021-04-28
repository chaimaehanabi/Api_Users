package com.example.api.demo.Testing;

import com.example.api.demo.Models.Utilisateur;
import com.example.api.demo.Repository.UtilisateurRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {
    @LocalServerPort
    int randomServerPort;
    @Autowired
    private TestRestTemplate restTemplate;
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
    public void testListUseres() {
        List<Utilisateur> Utilisateurs = entityManager.findAll();
        assertThat(Utilisateurs).size().isGreaterThan(0);
    }

    @Test
    public void testFindByName() {
        Utilisateur users = entityManager.findBynom("safae");
        assertThat(users.getNom()).isEqualTo("safae");
    }


}