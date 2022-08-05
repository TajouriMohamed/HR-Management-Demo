package com.javaproject.gp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 25)
    private String nomTache;
    @Column(length = 100)
    private String description;
    @Column(length = 15)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String deadline;
    @Column(length = 15)
    private String statut;
    @Column(length = 10)
    private String avancement;

    @ManyToOne
    @JoinColumn(name = "projetid", insertable = false, updatable = false)
    private Projet projet;
    private int projetid;

    @ManyToOne
    @JoinColumn(name = "persoid", insertable = false, updatable = false)
    private Personnel personnel;
    private int persoid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getAvancement() {
        return avancement;
    }

    public void setAvancement(String avancement) {
        this.avancement = avancement;
    }

    public int getProjetid() {
        return projetid;
    }

    public void setProjetid(int projetid) {
        this.projetid = projetid;
    }

    public int getPersoid() {
        return persoid;
    }

    public void setPersoid(int persoid) {
        this.persoid = persoid;
    }

    @Override
    public String toString() {
        return "Tache [id=" + id + ", nomTache=" + nomTache + ", description=" + description + ", deadline=" + deadline
                + ", statut=" + statut + ", avancement=" + avancement + ", projet=" + projet + ", projetid=" + projetid
                + ", personnel=" + personnel + ", persoid=" + persoid + "]";
    }
}
