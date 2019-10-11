package com.architecture.canalplus.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contrat")
public class Contrat implements Serializable {
    @Id
    private String numero;
    @ManyToOne
    private  Abonne abonne;
    private String AdresseAbonne;
    private String NomContrat;

    public Contrat(String numero, Abonne abonne, String adresseAbonne, String nomContrat) {
        this.numero = numero;
        this.abonne = abonne;
        AdresseAbonne = adresseAbonne;
        NomContrat = nomContrat;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Contrat() {
        super();
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public String getAdresseAbonne() {
        return AdresseAbonne;
    }

    public void setAdresseAbonne(String adresseAbonne) {
        AdresseAbonne = adresseAbonne;
    }

    public String getNomContrat() {
        return NomContrat;
    }

    public void setNomContrat(String nomContrat) {
        NomContrat = nomContrat;
    }
}
