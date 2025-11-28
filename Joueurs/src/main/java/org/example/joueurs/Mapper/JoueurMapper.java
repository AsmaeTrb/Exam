package org.example.joueurs.Mapper;

import feign.Response;
import org.example.joueurs.DTO.RequestDtoJoueur;
import org.example.joueurs.DTO.ResponseDtoJoueur;
import org.example.joueurs.Entities.Joueurs;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component

public class JoueurMapper {
    public Joueurs toEntity (RequestDtoJoueur requestDtoJoueur){
        Joueurs joueurs = new Joueurs();
        BeanUtils.copyProperties(requestDtoJoueur, joueurs);
        return joueurs;
    }
    public ResponseDtoJoueur toDto (Joueurs joueurs){
        ResponseDtoJoueur responseDtoJoueur = new ResponseDtoJoueur();
        BeanUtils.copyProperties(joueurs, responseDtoJoueur);
        return responseDtoJoueur;
    }
}
