package org.example.joueurs.Service;

import org.example.joueurs.DTO.RequestDtoJoueur;
import org.example.joueurs.DTO.ResponseDtoJoueur;
import org.example.joueurs.Entities.Joueurs;
import org.example.joueurs.JoueursApplication;
import org.example.joueurs.Mapper.JoueurMapper;
import org.example.joueurs.Repository.JoueurRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class JoueurService {
    private JoueurRepo joueurRepo;
    private JoueurMapper joueurMapper;
    public JoueurService(JoueurRepo joueurRepo, JoueurMapper joueurMapper) {
        this.joueurRepo = joueurRepo;
        this.joueurMapper = joueurMapper;
    }
    public ResponseDtoJoueur getJoueurById(int id) {
        Joueurs joueur = joueurRepo.findById(id).orElseThrow(() -> new RuntimeException("Joueur not found"));
        ResponseDtoJoueur responseDtoJoueur =joueurMapper.toDto(joueur);
        return responseDtoJoueur;
    }
    public List<ResponseDtoJoueur> getAllJoueurs() {
        return joueurRepo.findAll().stream().map(joueurMapper::toDto).collect(Collectors.toList());

    }
    public ResponseDtoJoueur addJoueur(RequestDtoJoueur  requestDtoJoueur) {
        Joueurs saved =joueurRepo.save(joueurMapper.toEntity(requestDtoJoueur));
        ResponseDtoJoueur respone = joueurMapper.toDto(saved);
        return respone;
    }
    public ResponseDtoJoueur updateJoueur(RequestDtoJoueur  requestDtoJoueur,Integer id) {
        Joueurs joueur= joueurRepo.findById(id).orElseThrow(() -> new RuntimeException("Joueur not found"));
        joueurRepo.save(joueurMapper.toEntity(requestDtoJoueur));
        ResponseDtoJoueur respone = joueurMapper.toDto(joueur);
        return respone;
    }
    public void  deleteJoueur(Integer id) {
        joueurRepo.deleteById(id);
    }
}
