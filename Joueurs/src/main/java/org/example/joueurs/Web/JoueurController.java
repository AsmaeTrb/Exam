package org.example.joueurs.Web;

import org.example.joueurs.DTO.RequestDtoJoueur;
import org.example.joueurs.DTO.ResponseDtoJoueur;
import org.example.joueurs.Mapper.JoueurMapper;
import org.example.joueurs.Repository.JoueurRepo;
import org.example.joueurs.Service.JoueurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Joueurs/")
public class JoueurController {
    private JoueurService joueurService;
    private JoueurRepo joueurRepo;
    private JoueurMapper joueurMapper;
    public JoueurController(JoueurService joueurService ,JoueurRepo joueurRepo, JoueurMapper joueurMapper) {
        this.joueurService = joueurService;
        this.joueurRepo = joueurRepo;
        this.joueurMapper = joueurMapper;
    }
    @PostMapping
    public ResponseEntity<ResponseDtoJoueur> ajouterJoueur(@RequestBody RequestDtoJoueur requestDtoJoueur) {
        return ResponseEntity.ok(joueurService.addJoueur(requestDtoJoueur));
    }
    @GetMapping
    public ResponseEntity<List<ResponseDtoJoueur>> getJoueur() {
        return ResponseEntity.ok(joueurService.getAllJoueurs());
    }
    @PostMapping("/{id}")
    public ResponseEntity<ResponseDtoJoueur>  modifierJoueur(@PathVariable int id, @RequestBody RequestDtoJoueur requestDtoJoueur) {
        return ResponseEntity.ok(joueurService.updateJoueur(requestDtoJoueur,id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDtoJoueur> getJoueurById(@PathVariable int id) {
        return ResponseEntity.ok(joueurService.getJoueurById(id));
    }
    @PutMapping("/{id}")
    public void supprimerJoueur(@PathVariable int id) {
        joueurRepo.deleteById(id);
    }
}
