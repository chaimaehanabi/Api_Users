package com.example.api.demo.Testing;

import com.example.api.demo.Models.Utilisateur;
import com.example.api.demo.Repository.UtilisateurRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {
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

    @LocalServerPort
    int randomServerPort;

    @Test
    public void testCreateEmployeeSuccess() throws URISyntaxException {
        final String baseUrl = "http://localhost:8080" + randomServerPort + "/users/";
        URI uri = new URI(baseUrl);
        Utilisateur Utilisateurs = new Utilisateur("Peter", "f", "nn");
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RAM-PERSIST", "true");
        HttpEntity<Utilisateur> httpEntity = new HttpEntity<>(Utilisateurs, headers);
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(uri, httpEntity,
                String.class);

        // Verify request succeed
        Assert.assertEquals(201, responseEntity.getStatusCodeValue());
    }

}