package com.s3bastiank.cybercentrum.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "role_uzytkownikow")
public class RoleAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_roli", nullable = false)
    private Integer roleId;

    @Column(name = "id_uzytkownika", nullable = false)
    private Integer userId;

    @Column(name = "data_nadania")
    private LocalDateTime grantedAt;

    @Column(name = "kto_nadal")
    private Integer whoGranted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getGrantedAt() {
        return grantedAt;
    }

    public void setGrantedAt(LocalDateTime grantedAt) {
        this.grantedAt = grantedAt;
    }

    public Integer getWhoGranted() {
        return whoGranted;
    }

    public void setWhoGranted(Integer whoGranted) {
        this.whoGranted = whoGranted;
    }
}
