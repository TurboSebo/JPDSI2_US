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
@Table(name = "role")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByIdRoli", query = "SELECT r FROM Role r WHERE r.idRoli = :idRoli"),
    @NamedQuery(name = "Role.findByNazwaRoli", query = "SELECT r FROM Role r WHERE r.nazwaRoli = :nazwaRoli"),
    @NamedQuery(name = "Role.findByCzyAktywna", query = "SELECT r FROM Role r WHERE r.czyAktywna = :czyAktywna"),
    @NamedQuery(name = "Role.findByDataZaimplementowania", query = "SELECT r FROM Role r WHERE r.dataZaimplementowania = :dataZaimplementowania"),
    @NamedQuery(name = "Role.findByDataDezaktywacji", query = "SELECT r FROM Role r WHERE r.dataDezaktywacji = :dataDezaktywacji")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_roli")
    private Integer idRoli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazwa_roli")
    private String nazwaRoli;
    @Column(name = "czy_aktywna")
    private Boolean czyAktywna;
    @Column(name = "data_zaimplementowania")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataZaimplementowania;
    @Column(name = "data_dezaktywacji")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDezaktywacji;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRoli")
    private Collection<RoleUzytkownikow> roleUzytkownikowCollection;

    public Role() {
    }

    public Role(Integer idRoli) {
        this.idRoli = idRoli;
    }

    public Role(Integer idRoli, String nazwaRoli) {
        this.idRoli = idRoli;
        this.nazwaRoli = nazwaRoli;
    }

    public Integer getIdRoli() {
        return idRoli;
    }

    public void setIdRoli(Integer idRoli) {
        this.idRoli = idRoli;
    }

    public String getNazwaRoli() {
        return nazwaRoli;
    }

    public void setNazwaRoli(String nazwaRoli) {
        this.nazwaRoli = nazwaRoli;
    }

    public Boolean getCzyAktywna() {
        return czyAktywna;
    }

    public void setCzyAktywna(Boolean czyAktywna) {
        this.czyAktywna = czyAktywna;
    }

    public Date getDataZaimplementowania() {
        return dataZaimplementowania;
    }

    public void setDataZaimplementowania(Date dataZaimplementowania) {
        this.dataZaimplementowania = dataZaimplementowania;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoli != null ? idRoli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.idRoli == null && other.idRoli != null) || (this.idRoli != null && !this.idRoli.equals(other.idRoli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.jpa.jpa_example.entities.Role[ idRoli=" + idRoli + " ]";
    }
    
}
