package com.s3bastiank.cybercentrum.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "komentarze")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_komentarza")
    private Integer id;

    @Column(name = "tresc", nullable = false)
    private String content;

    @Column(name = "data_wstawienia", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "czy_usuniete", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "id_posta", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "id_uzytkownika", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "kto_usunal")
    private User whoDeleted;

    @Column(name = "data_usuniecia")
    private LocalDateTime deleteDateTime;
    //


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getWhoDeleted() {
        return whoDeleted;
    }

    public void setWhoDeleted(User whoDeleted) {
        this.whoDeleted = whoDeleted;
    }

    public LocalDateTime getDeleteDateTime() {
        return deleteDateTime;
    }

    public void setDeleteDateTime(LocalDateTime deleteDateTime) {
        this.deleteDateTime = deleteDateTime;
    }
}
