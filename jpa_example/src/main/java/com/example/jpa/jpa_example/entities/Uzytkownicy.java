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
@Table(name = "uzytkownicy")
@NamedQueries({
    @NamedQuery(name = "Uzytkownicy.findAll", query = "SELECT u FROM Uzytkownicy u"),
    @NamedQuery(name = "Uzytkownicy.findByIdUzytkownika", query = "SELECT u FROM Uzytkownicy u WHERE u.idUzytkownika = :idUzytkownika"),
    @NamedQuery(name = "Uzytkownicy.findByNazwaUzytkownika", query = "SELECT u FROM Uzytkownicy u WHERE u.nazwaUzytkownika = :nazwaUzytkownika"),
    @NamedQuery(name = "Uzytkownicy.findByHaslo", query = "SELECT u FROM Uzytkownicy u WHERE u.haslo = :haslo"),
    @NamedQuery(name = "Uzytkownicy.findByEmail", query = "SELECT u FROM Uzytkownicy u WHERE u.email = :email"),
    @NamedQuery(name = "Uzytkownicy.findByDataRejestracji", query = "SELECT u FROM Uzytkownicy u WHERE u.dataRejestracji = :dataRejestracji"),
    @NamedQuery(name = "Uzytkownicy.findByOMnie", query = "SELECT u FROM Uzytkownicy u WHERE u.oMnie = :oMnie"),
    @NamedQuery(name = "Uzytkownicy.findByKontoAktywne", query = "SELECT u FROM Uzytkownicy u WHERE u.kontoAktywne = :kontoAktywne"),
    @NamedQuery(name = "Uzytkownicy.findByDataDezaktywacji", query = "SELECT u FROM Uzytkownicy u WHERE u.dataDezaktywacji = :dataDezaktywacji")})
public class Uzytkownicy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_uzytkownika")
    private Integer idUzytkownika;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazwa_uzytkownika")
    private String nazwaUzytkownika;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "haslo")
    private String haslo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Column(name = "data_rejestracji")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRejestracji;
    @Size(max = 255)
    @Column(name = "o_mnie")
    private String oMnie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "konto_aktywne")
    private Boolean kontoAktywne;
    @Column(name = "data_dezaktywacji")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDezaktywacji;
    @OneToMany(mappedBy = "idUzytkownika")
    private Collection<RoleUzytkownikow> roleUzytkownikowCollection;
    @OneToMany(mappedBy = "ktoNadal")
    private Collection<RoleUzytkownikow> roleUzytkownikowCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUzytkownika")
    private Collection<Komentarze> komentarzeCollection;
    @OneToMany(mappedBy = "ktoUsunal")
    private Collection<Komentarze> komentarzeCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUzytkownika")
    private Collection<Posty> postyCollection;
    @OneToMany(mappedBy = "ktoUsunal")
    private Collection<Posty> postyCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZglaszajacego")
    private Collection<Zgloszenia> zgloszeniaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUzytkownika")
    private Collection<Powiadomienia> powiadomieniaCollection;
    @OneToMany(mappedBy = "ktoZarejestrowal")
    private Collection<Uzytkownicy> uzytkownicyCollection;
    @JoinColumn(name = "kto_zarejestrowal", referencedColumnName = "id_uzytkownika")
    @ManyToOne
    private Uzytkownicy ktoZarejestrowal;

    public Uzytkownicy() {
    }

    public Uzytkownicy(Integer idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public Uzytkownicy(Integer idUzytkownika, String nazwaUzytkownika, String haslo, String email, Boolean kontoAktywne) {
        this.idUzytkownika = idUzytkownika;
        this.nazwaUzytkownika = nazwaUzytkownika;
        this.haslo = haslo;
        this.email = email;
        this.kontoAktywne = kontoAktywne;
    }

    public Integer getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Integer idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public String getNazwaUzytkownika() {
        return nazwaUzytkownika;
    }

    public void setNazwaUzytkownika(String nazwaUzytkownika) {
        this.nazwaUzytkownika = nazwaUzytkownika;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataRejestracji() {
        return dataRejestracji;
    }

    public void setDataRejestracji(Date dataRejestracji) {
        this.dataRejestracji = dataRejestracji;
    }

    public String getOMnie() {
        return oMnie;
    }

    public void setOMnie(String oMnie) {
        this.oMnie = oMnie;
    }

    public Boolean getKontoAktywne() {
        return kontoAktywne;
    }

    public void setKontoAktywne(Boolean kontoAktywne) {
        this.kontoAktywne = kontoAktywne;
    }

    public Date getDataDezaktywacji() {
        return dataDezaktywacji;
    }

    public void setDataDezaktywacji(Date dataDezaktywacji) {
        this.dataDezaktywacji = dataDezaktywacji;
    }

    public Collection<RoleUzytkownikow> getRoleUzytkownikowCollection() {
        return roleUzytkownikowCollection;
    }

    public void setRoleUzytkownikowCollection(Collection<RoleUzytkownikow> roleUzytkownikowCollection) {
        this.roleUzytkownikowCollection = roleUzytkownikowCollection;
    }

    public Collection<RoleUzytkownikow> getRoleUzytkownikowCollection1() {
        return roleUzytkownikowCollection1;
    }

    public void setRoleUzytkownikowCollection1(Collection<RoleUzytkownikow> roleUzytkownikowCollection1) {
        this.roleUzytkownikowCollection1 = roleUzytkownikowCollection1;
    }

    public Collection<Komentarze> getKomentarzeCollection() {
        return komentarzeCollection;
    }

    public void setKomentarzeCollection(Collection<Komentarze> komentarzeCollection) {
        this.komentarzeCollection = komentarzeCollection;
    }

    public Collection<Komentarze> getKomentarzeCollection1() {
        return komentarzeCollection1;
    }

    public void setKomentarzeCollection1(Collection<Komentarze> komentarzeCollection1) {
        this.komentarzeCollection1 = komentarzeCollection1;
    }

    public Collection<Posty> getPostyCollection() {
        return postyCollection;
    }

    public void setPostyCollection(Collection<Posty> postyCollection) {
        this.postyCollection = postyCollection;
    }

    public Collection<Posty> getPostyCollection1() {
        return postyCollection1;
    }

    public void setPostyCollection1(Collection<Posty> postyCollection1) {
        this.postyCollection1 = postyCollection1;
    }

    public Collection<Zgloszenia> getZgloszeniaCollection() {
        return zgloszeniaCollection;
    }

    public void setZgloszeniaCollection(Collection<Zgloszenia> zgloszeniaCollection) {
        this.zgloszeniaCollection = zgloszeniaCollection;
    }

    public Collection<Powiadomienia> getPowiadomieniaCollection() {
        return powiadomieniaCollection;
    }

    public void setPowiadomieniaCollection(Collection<Powiadomienia> powiadomieniaCollection) {
        this.powiadomieniaCollection = powiadomieniaCollection;
    }

    public Collection<Uzytkownicy> getUzytkownicyCollection() {
        return uzytkownicyCollection;
    }

    public void setUzytkownicyCollection(Collection<Uzytkownicy> uzytkownicyCollection) {
        this.uzytkownicyCollection = uzytkownicyCollection;
    }

    public Uzytkownicy getKtoZarejestrowal() {
        return ktoZarejestrowal;
    }

    public void setKtoZarejestrowal(Uzytkownicy ktoZarejestrowal) {
        this.ktoZarejestrowal = ktoZarejestrowal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUzytkownika != null ? idUzytkownika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzytkownicy)) {
            return false;
        }
        Uzytkownicy other = (Uzytkownicy) object;
        if ((this.idUzytkownika == null && other.idUzytkownika != null) || (this.idUzytkownika != null && !this.idUzytkownika.equals(other.idUzytkownika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.jpa.jpa_example.entities.Uzytkownicy[ idUzytkownika=" + idUzytkownika + " ]";
    }
    
}
