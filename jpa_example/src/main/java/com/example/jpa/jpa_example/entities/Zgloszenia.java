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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "zgloszenia")
@NamedQueries({
    @NamedQuery(name = "Zgloszenia.findAll", query = "SELECT z FROM Zgloszenia z"),
    @NamedQuery(name = "Zgloszenia.findByIdZgloszenia", query = "SELECT z FROM Zgloszenia z WHERE z.idZgloszenia = :idZgloszenia"),
    @NamedQuery(name = "Zgloszenia.findByTrescZgloszenia", query = "SELECT z FROM Zgloszenia z WHERE z.trescZgloszenia = :trescZgloszenia"),
    @NamedQuery(name = "Zgloszenia.findByDataZgloszenia", query = "SELECT z FROM Zgloszenia z WHERE z.dataZgloszenia = :dataZgloszenia")})
public class Zgloszenia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zgloszenia")
    private Integer idZgloszenia;
    @Size(max = 2500)
    @Column(name = "tresc_zgloszenia")
    private String trescZgloszenia;
    @Column(name = "data_zgloszenia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataZgloszenia;
    @JoinColumn(name = "id_zglaszajacego", referencedColumnName = "id_uzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy idZglaszajacego;

    public Zgloszenia() {
    }

    public Zgloszenia(Integer idZgloszenia) {
        this.idZgloszenia = idZgloszenia;
    }

    public Integer getIdZgloszenia() {
        return idZgloszenia;
    }

    public void setIdZgloszenia(Integer idZgloszenia) {
        this.idZgloszenia = idZgloszenia;
    }

    public String getTrescZgloszenia() {
        return trescZgloszenia;
    }

    public void setTrescZgloszenia(String trescZgloszenia) {
        this.trescZgloszenia = trescZgloszenia;
    }

    public Date getDataZgloszenia() {
        return dataZgloszenia;
    }

    public void setDataZgloszenia(Date dataZgloszenia) {
        this.dataZgloszenia = dataZgloszenia;
    }

    public Uzytkownicy getIdZglaszajacego() {
        return idZglaszajacego;
    }

    public void setIdZglaszajacego(Uzytkownicy idZglaszajacego) {
        this.idZglaszajacego = idZglaszajacego;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZgloszenia != null ? idZgloszenia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zgloszenia)) {
            return false;
        }
        Zgloszenia other = (Zgloszenia) object;
        if ((this.idZgloszenia == null && other.idZgloszenia != null) || (this.idZgloszenia != null && !this.idZgloszenia.equals(other.idZgloszenia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.jpa.jpa_example.entities.Zgloszenia[ idZgloszenia=" + idZgloszenia + " ]";
    }
    
}
