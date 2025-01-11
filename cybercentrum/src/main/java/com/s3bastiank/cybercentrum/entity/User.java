package com.s3bastiank.cybercentrum.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "uzytkownicy") // Wskazuje, że encja odpowiada tabeli "uzytkownicy"
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uzytkownika") // Mapowanie kolumny z bazy
    private Integer id;

    @Column(name = "nazwa_uzytkownika", nullable = false, unique = true)
    private String username;

    @Column(name = "haslo", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "data_rejestracji")
    private LocalDateTime registrationDate;

    @Column(name = "o_mnie")
    private String aboutMe;

    @Column(name = "konto_aktywne")
    private boolean activeAccount;

    @Column(name = "data_dezaktywacji")
    private LocalDateTime deactivationDate;

    @Column(name = "kto_zarejestrowal")
    private Integer registeredBy;

    // Gettery i settery
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getAboutMe() {return aboutMe;}
    public void setAboutMe(String aboutMe) {this.aboutMe = aboutMe;}

    public boolean isActiveAccount() {return activeAccount;}

    public void setActiveAccount(boolean activeAccount) {this.activeAccount = activeAccount;}

    public LocalDateTime getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(LocalDateTime deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    public Integer getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(Integer registeredBy) {
        this.registeredBy = registeredBy;
    }
}