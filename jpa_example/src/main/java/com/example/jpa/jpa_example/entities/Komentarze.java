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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "komentarze")
@NamedQueries({
    @NamedQuery(name = "Komentarze.findAll", query = "SELECT k FROM Komentarze k"),
    @NamedQuery(name = "Komentarze.findByIdKomentarza", query = "SELECT k FROM Komentarze k WHERE k.idKomentarza = :idKomentarza"),
    @NamedQuery(name = "Komentarze.findByTresc", query = "SELECT k FROM Komentarze k WHERE k.tresc = :tresc"),
    @NamedQuery(name = "Komentarze.findByDataWstawienia", query = "SELECT k FROM Komentarze k WHERE k.dataWstawienia = :dataWstawienia"),
    @NamedQuery(name = "Komentarze.findByCzyUsuniete", query = "SELECT k FROM Komentarze k WHERE k.czyUsuniete = :czyUsuniete"),
    @NamedQuery(name = "Komentarze.findByDataUsuniecia", query = "SELECT k FROM Komentarze k WHERE k.dataUsuniecia = :dataUsuniecia")})
public class Komentarze implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_komentarza")
    private Integer idKomentarza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "tresc")
    private String tresc;
    @Column(name = "data_wstawienia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataWstawienia;
    @Column(name = "czy_usuniete")
    private Boolean czyUsuniete;
    @Column(name = "data_usuniecia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUsuniecia;
    @JoinColumn(name = "id_posta", referencedColumnName = "id_posta")
    @ManyToOne(optional = false)
    private Posty idPosta;
    @JoinColumn(name = "id_uzytkownika", referencedColumnName = "id_uzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy idUzytkownika;
    @JoinColumn(name = "kto_usunal", referencedColumnName = "id_uzytkownika")
    @ManyToOne
    private Uzytkownicy ktoUsunal;

    public Komentarze() {
    }

    public Komentarze(Integer idKomentarza) {
        this.idKomentarza = idKomentarza;
    }

    public Komentarze(Integer idKomentarza, String tresc) {
        this.idKomentarza = idKomentarza;
        this.tresc = tresc;
    }

    public Integer getIdKomentarza() {
        return idKomentarza;
    }

    public void setIdKomentarza(Integer idKomentarza) {
        this.idKomentarza = idKomentarza;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Date getDataWstawienia() {
        return dataWstawienia;
    }

    public void setDataWstawienia(Date dataWstawienia) {
        this.dataWstawienia = dataWstawienia;
    }

    public Boolean getCzyUsuniete() {
        return czyUsuniete;
    }

    public void setCzyUsuniete(Boolean czyUsuniete) {
        this.czyUsuniete = czyUsuniete;
    }

    public Date getDataUsuniecia() {
        return dataUsuniecia;
    }

    public void setDataUsuniecia(Date dataUsuniecia) {
        this.dataUsuniecia = dataUsuniecia;
    }

    public Posty getIdPosta() {
        return idPosta;
    }

    public void setIdPosta(Posty idPosta) {
        this.idPosta = idPosta;
    }

    public Uzytkownicy getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Uzytkownicy idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public Uzytkownicy getKtoUsunal() {
        return ktoUsunal;
    }

    public void setKtoUsunal(Uzytkownicy ktoUsunal) {
        this.ktoUsunal = ktoUsunal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKomentarza != null ? idKomentarza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Komentarze)) {
            return false;
        }
        Komentarze other = (Komentarze) object;
        if ((this.idKomentarza == null && other.idKomentarza != null) || (this.idKomentarza != null && !this.idKomentarza.equals(other.idKomentarza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.jpa.jpa_example.entities.Komentarze[ idKomentarza=" + idKomentarza + " ]";
    }
    
}
