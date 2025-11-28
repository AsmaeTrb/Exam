package org.example.equipe.Web;

import org.example.equipe.DTO.RequestDtoEquipe;
import org.example.equipe.DTO.ResponseDtoEquipe;
import org.example.equipe.Entities.Equipe;
import org.example.equipe.Mapper.EquipesMapper;
import org.example.equipe.Repository.EquipesRepo;
import org.example.equipe.Service.EquipesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/equipes")
public class EquipeController {
    private final EquipesRepo equipesRepo;
    private EquipesService equipesService;
    private EquipesMapper equipesMapper;
    public EquipeController(EquipesService equipesService, EquipesMapper equipesMapper, EquipesRepo equipesRepo) {
        this.equipesService = equipesService;
        this.equipesMapper = equipesMapper;
        this.equipesRepo = equipesRepo;
    }
    @PostMapping
    public ResponseEntity<ResponseDtoEquipe> addEquipe(@RequestBody RequestDtoEquipe requestDtoEquipe) {
        return ResponseEntity.ok(equipesService.CreateEquipe(requestDtoEquipe)) ;
    }
    @PostMapping("/{id}")
    public ResponseEntity<ResponseDtoEquipe> updateEquipe(@RequestBody RequestDtoEquipe requestDtoEquipe, @PathVariable int id) {
        return ResponseEntity.ok(equipesService.Update(requestDtoEquipe, id)) ;
    }
    @GetMapping
    public ResponseEntity<List<ResponseDtoEquipe>> getAllEquipes() {
        return ResponseEntity.ok(equipesService.getAllEquipes());
    }
    @PutMapping("/{id}")
    public void deleteEquipe(@PathVariable int id) {
        equipesService.Delete(id);
    }


}
