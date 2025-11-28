package org.example.equipe.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equipe_id ;
    @Column(unique = true, nullable = false)
    private int numero_serie;
    private String code;
    private String libelle;
    private int  responsable_id;
}
