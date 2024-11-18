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
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "role_uzytkownikow")
@NamedQueries({
    @NamedQuery(name = "RoleUzytkownikow.findAll", query = "SELECT r FROM RoleUzytkownikow r"),
    @NamedQuery(name = "RoleUzytkownikow.findById", query = "SELECT r FROM RoleUzytkownikow r WHERE r.id = :id"),
    @NamedQuery(name = "RoleUzytkownikow.findByDataNadania", query = "SELECT r FROM RoleUzytkownikow r WHERE r.dataNadania = :dataNadania"),
    @NamedQuery(name = "RoleUzytkownikow.findByDataOdebrania", query = "SELECT r FROM RoleUzytkownikow r WHERE r.dataOdebrania = :dataOdebrania")})
public class RoleUzytkownikow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_nadania")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNadania;
    @Column(name = "data_odebrania")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOdebrania;
    @JoinColumn(name = "id_roli", referencedColumnName = "id_roli")
    @ManyToOne(optional = false)
    private Role idRoli;
    @JoinColumn(name = "id_uzytkownika", referencedColumnName = "id_uzytkownika")
    @ManyToOne
    private Uzytkownicy idUzytkownika;
    @JoinColumn(name = "kto_nadal", referencedColumnName = "id_uzytkownika")
    @ManyToOne
    private Uzytkownicy ktoNadal;

    public RoleUzytkownikow() {
    }

    public RoleUzytkownikow(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataNadania() {
        return dataNadania;
    }

    public void setDataNadania(Date dataNadania) {
        this.dataNadania = dataNadania;
    }

    public Date getDataOdebrania() {
        return dataOdebrania;
    }

    public void setDataOdebrania(Date dataOdebrania) {
        this.dataOdebrania = dataOdebrania;
    }

    public Role getIdRoli() {
        return idRoli;
    }

    public void setIdRoli(Role idRoli) {
        this.idRoli = idRoli;
    }

    public Uzytkownicy getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Uzytkownicy idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public Uzytkownicy getKtoNadal() {
        return ktoNadal;
    }

    public void setKtoNadal(Uzytkownicy ktoNadal) {
        this.ktoNadal = ktoNadal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleUzytkownikow)) {
            return false;
        }
        RoleUzytkownikow other = (RoleUzytkownikow) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.jpa.jpa_example.entities.RoleUzytkownikow[ id=" + id + " ]";
    }
    
}
