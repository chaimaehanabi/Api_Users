package com.example.api.demo.Controllers;

import com.example.api.demo.Models.Utilisateur;
import com.example.api.demo.Repository.UtilisateurRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
@Api(value = "Employee Management System", description = "Operations pertaining to employee in Employee Management System")
public class UtilisateurController {
    @Autowired
    UtilisateurRepository repository;

    @GetMapping("/users/")
    public List<Utilisateur> getAllUtilisateur() {
        System.out.println("Get all Utilisateur...");
        List<Utilisateur> Utilisateur = new ArrayList<>();
        repository.findAll().forEach(Utilisateur::add);
        return Utilisateur;
    }

    //Affichafe des utilisateur par id
    @GetMapping("/users/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable(value = "id") Long UtilisateurId
    )
            throws ResourceNotFoundException {
        Utilisateur Utilisateur = repository.findById(UtilisateurId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found for this id :: " + UtilisateurId));
        return ResponseEntity.ok().body(Utilisateur);
    }

    ///add user
    @PostMapping("/users")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur Utilisateur) {
        return repository.save(new Utilisateur(Utilisateur.getNom(), Utilisateur.getPrenom(), Utilisateur.getEmail()));
    }


    //supprimer un user par son id
    @DeleteMapping("/users/delete/{id}")
    public Map<String, Boolean> deleteUtilisateur(@PathVariable(value = "id") Long UtilisateurId)
            throws ResourceNotFoundException {
        Utilisateur Utilisateur = repository.findById(UtilisateurId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found  id :: " + UtilisateurId));

        repository.delete(Utilisateur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    //supprimer tous les utilisateurs
    @DeleteMapping("/users/delete")
    public ResponseEntity<String> deleteAllUtilisateur() {
        System.out.println("Delete All Utilisateur...");
        repository.deleteAll();
        return new ResponseEntity<>("All Utilisateurs have been deleted!", HttpStatus.OK);
    }

    //update users
    @PutMapping("/users/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable("id") long id, @RequestBody Utilisateur Utilisateur) {
        System.out.println("Update Utilisateur with ID = " + id + "...");
        Optional<Utilisateur> UtilisateurInfo = repository.findById(id);

        if (UtilisateurInfo.isPresent()) {
            Utilisateur utilisateur = UtilisateurInfo.get();
            utilisateur.setNom(Utilisateur.getNom());
            utilisateur.setPrenom(Utilisateur.getPrenom());
            utilisateur.setEmail(Utilisateur.getEmail());
            return new ResponseEntity<>(repository.save(Utilisateur), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}