package com.abdo.project.spring.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
   // private int score;
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY) // patient c'est le nom d'oject dans la classe RendezVous
    private Collection<RendezVous> rendezVous;

}
