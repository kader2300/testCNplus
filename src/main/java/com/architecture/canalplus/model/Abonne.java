package com.architecture.canalplus.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "abonne")
public class Abonne implements Serializable {

    @Id
    private String idAbonne;

    String nom;
    String adresse;
    @OneToMany
    private List<Contrat> contrats;

    public Abonne(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }
    public Abonne() {
        super();
    }

    public String getIdAbonne() {
        return idAbonne;
    }

    public void setIdAbonne(String idAbonne) {
        this.idAbonne = idAbonne;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Abonne{" +
                "id=" + idAbonne +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", contrats=" + contrats +
                '}';
    }
}
