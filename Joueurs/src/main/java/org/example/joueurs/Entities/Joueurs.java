package org.example.joueurs.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Joueurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer joueur_id;
    private String nom;
    private String position;
    private Double salary;
    private int nombrebut;
    private int responsable_id;
}
