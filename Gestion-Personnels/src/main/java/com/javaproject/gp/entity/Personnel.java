package com.javaproject.gp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 25)
    private String nom;
    @Column(nullable = false, length = 25)
    private String prenom;
    @Column(nullable = false, length = 25)
    private String cin;
    @Column(nullable = false, length = 25)
    private String post;
    @Column(nullable = false, length = 25)
    private String hTravail;
    private float salaire;
    @Column(nullable = false, length = 25)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String gethTravail() {
        return hTravail;
    }

    public void sethTravail(String hTravail) {
        this.hTravail = hTravail;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Personnel [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", post=" + post
                + ", hTravail=" + hTravail + ", salaire=" + salaire + ", password=" + password + "]";
    }
}
