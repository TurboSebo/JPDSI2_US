/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jpa.jpa_example.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "powiadomienia")
@NamedQueries({
    @NamedQuery(name = "Powiadomienia.findAll", query = "SELECT p FROM Powiadomienia p"),
    @NamedQuery(name = "Powiadomienia.findByIdPowiadomienia", query = "SELECT p FROM Powiadomienia p WHERE p.idPowiadomienia = :idPowiadomienia"),
    @NamedQuery(name = "Powiadomienia.findByTemat", query = "SELECT p FROM Powiadomienia p WHERE p.temat = :temat"),
    @NamedQuery(name = "Powiadomienia.findByCzyOdczytane", query = "SELECT p FROM Powiadomienia p WHERE p.czyOdczytane = :czyOdczytane")})
public class Powiadomienia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_powiadomienia")
    private Integer idPowiadomienia;
    @Size(max = 50)
    @Column(name = "temat")
    private String temat;
    @Lob
    @Size(max = 65535)
    @Column(name = "tresc")
    private String tresc;
    @Column(name = "czy_odczytane")
    private Boolean czyOdczytane;
    @JoinColumn(name = "id_uzytkownika", referencedColumnName = "id_uzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy idUzytkownika;

    public Powiadomienia() {
    }

    public Powiadomienia(Integer idPowiadomienia) {
        this.idPowiadomienia = idPowiadomienia;
    }

    public Integer getIdPowiadomienia() {
        return idPowiadomienia;
    }

    public void setIdPowiadomienia(Integer idPowiadomienia) {
        this.idPowiadomienia = idPowiadomienia;
    }

    public String getTemat() {
        return temat;
    }

    public void setTemat(String temat) {
        this.temat = temat;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Boolean getCzyOdczytane() {
        return czyOdczytane;
    }

    public void setCzyOdczytane(Boolean czyOdczytane) {
        this.czyOdczytane = czyOdczytane;
    }

    public Uzytkownicy getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Uzytkownicy idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPowiadomienia != null ? idPowiadomienia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Powiadomienia)) {
            return false;
        }
        Powiadomienia other = (Powiadomienia) object;
        if ((this.idPowiadomienia == null && other.idPowiadomienia != null) || (this.idPowiadomienia != null && !this.idPowiadomienia.equals(other.idPowiadomienia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.jpa.jpa_example.entities.Powiadomienia[ idPowiadomienia=" + idPowiadomienia + " ]";
    }
    
}
