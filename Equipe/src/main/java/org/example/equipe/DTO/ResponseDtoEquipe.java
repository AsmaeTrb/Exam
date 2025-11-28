package org.example.equipe.DTO;

import jakarta.persistence.Column;
import lombok.Data;
@Data
public class ResponseDtoEquipe {
    private Integer equipe_id ;
    private int numero_serie;
    private String code;
    private String libelle;
    private int  responsable;
}
