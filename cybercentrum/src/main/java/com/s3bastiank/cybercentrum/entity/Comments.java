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

    @Column(name = "czy_usuniete", nullable = false)
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "id_posta", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "id_uzytkownika", nullable = false)
    private User author;
}
