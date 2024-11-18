/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jpa.jpa_example.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "posty")
@NamedQueries({
    @NamedQuery(name = "Posty.findAll", query = "SELECT p FROM Posty p"),
    @NamedQuery(name = "Posty.findByIdPosta", query = "SELECT p FROM Posty p WHERE p.idPosta = :idPosta"),
    @NamedQuery(name = "Posty.findByTytulPosta", query = "SELECT p FROM Posty p WHERE p.tytulPosta = :tytulPosta"),
    @NamedQuery(name = "Posty.findByTresc", query = "SELECT p FROM Posty p WHERE p.tresc = :tresc"),
    @NamedQuery(name = "Posty.findByDataUtworzenia", query = "SELECT p FROM Posty p WHERE p.dataUtworzenia = :dataUtworzenia"),
    @NamedQuery(name = "Posty.findByCzyUsuniete", query = "SELECT p FROM Posty p WHERE p.czyUsuniete = :czyUsuniete"),
    @NamedQuery(name = "Posty.findByDataUsuniecia", query = "SELECT p FROM Posty p WHERE p.dataUsuniecia = :dataUsuniecia")})
public class Posty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_posta")
    private Integer idPosta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tytul_posta")
    private String tytulPosta;
    @Size(max = 5000)
    @Column(name = "tresc")
    private String tresc;
    @Column(name = "data_utworzenia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUtworzenia;
    @Column(name = "czy_usuniete")
    private Boolean czyUsuniete;
    @Column(name = "data_usuniecia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUsuniecia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPosta")
    private Collection<Komentarze> komentarzeCollection;
    @JoinColumn(name = "id_uzytkownika", referencedColumnName = "id_uzytkownika")
    @ManyToOne(optional = false)
    private Uzytkownicy idUzytkownika;
    @JoinColumn(name = "kto_usunal", referencedColumnName = "id_uzytkownika")
    @ManyToOne
    private Uzytkownicy ktoUsunal;

    public Posty() {
    }

    public Posty(Integer idPosta) {
        this.idPosta = idPosta;
    }

    public Posty(Integer idPosta, String tytulPosta) {
        this.idPosta = idPosta;
        this.tytulPosta = tytulPosta;
    }

    public Integer getIdPosta() {
        return idPosta;
    }

    public void setIdPosta(Integer idPosta) {
        this.idPosta = idPosta;
    }

    public String getTytulPosta() {
        return tytulPosta;
    }

    public void setTytulPosta(String tytulPosta) {
        this.tytulPosta = tytulPosta;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
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

    public Collection<Komentarze> getKomentarzeCollection() {
        return komentarzeCollection;
    }

    public void setKomentarzeCollection(Collection<Komentarze> komentarzeCollection) {
        this.komentarzeCollection = komentarzeCollection;
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
        hash += (idPosta != null ? idPosta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posty)) {
            return false;
        }
        Posty other = (Posty) object;
        if ((this.idPosta == null && other.idPosta != null) || (this.idPosta != null && !this.idPosta.equals(other.idPosta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.jpa.jpa_example.entities.Posty[ idPosta=" + idPosta + " ]";
    }
    
}
