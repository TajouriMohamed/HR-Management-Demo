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
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String sujet;
    @Column(length = 255)
    private String message;
    @Column(length = 10)
    private String type;

    @ManyToOne
    @JoinColumn(name = "id_perso", insertable = false, updatable = false)
    private Personnel personnel;
    private int id_perso;

    @ManyToOne
    @JoinColumn(name = "id_admin", insertable = false, updatable = false)
    private Admin admin;
    private int id_admin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_perso() {
        return id_perso;
    }

    public void setId_perso(int id_perso) {
        this.id_perso = id_perso;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", sujet=" + sujet + ", message=" + message + ", type=" + type + ", personnel="
                + personnel + ", id_perso=" + id_perso + ", admin=" + admin + ", id_admin=" + id_admin + "]";
    }

}
