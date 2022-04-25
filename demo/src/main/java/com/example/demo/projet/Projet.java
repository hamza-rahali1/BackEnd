package com.example.demo.projet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Projet implements Serializable {

    @Id
    @SequenceGenerator(
            name = "projet_sequence",
            sequenceName = "projet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "projet_sequence"
    )
    private Long id;
    private String nomProjet;

    @Lob
    @Column(name="CONTENT", length=512)
    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String image;

    private String video;

    private String etat;

    public Projet(String nomProjet, String description, String image, String video, String etat) {
        this.nomProjet = nomProjet;
        this.description = description;
        this.image = image;
        this.video = video;
        this.etat = etat;
    }
}
