package com.example.api.demo.Repository;
import com.example.api.demo.Models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findBynom(String nom);
}
