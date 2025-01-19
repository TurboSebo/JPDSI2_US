package com.s3bastiank.cybercentrum.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posty")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_posta")
    private Integer id;

    @Column(name = "tytul_posta", nullable = false)
    private String title;

    @Column(name = "tresc")
    private String content;

    @Column(name = "data_utworzenia", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "czy_usuniete", nullable = false)
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "id_uzytkownika", nullable = false)
    private User author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
