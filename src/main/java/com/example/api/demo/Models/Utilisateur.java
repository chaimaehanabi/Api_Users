package com.example.api.demo.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String nom;
    public String Prenom;
    @javax.validation.constraints.Email
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    public String Email;
    public String address;
    public String Nom_entreprise;
    private String pwd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNom_entreprise() {
        return Nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        Nom_entreprise = nom_entreprise;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email) {
        this.nom = nom;
        this.Prenom = prenom;
        this.Email = email;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Email='" + Email + '\'' +
                ", address='" + address + '\'' +
                ", Nom_entreprise='" + Nom_entreprise + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public Utilisateur(long id, String nom, String prenom, String email, String address, String nom_entreprise, String pwd) {
        this.id = id;
        this.nom = nom;
        this.Prenom = prenom;
        this.Email = email;
        this.address = address;
        this.Nom_entreprise = nom_entreprise;
        this.pwd = pwd;
    }
}
