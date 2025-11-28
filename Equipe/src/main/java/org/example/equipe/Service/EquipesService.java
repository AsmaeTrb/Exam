package org.example.equipe.Service;

import org.example.equipe.DTO.RequestDtoEquipe;
import org.example.equipe.DTO.ResponseDtoEquipe;
import org.example.equipe.Entities.Equipe;
import org.example.equipe.Mapper.EquipesMapper;
import org.example.equipe.Repository.EquipesRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipesService {
    private EquipesRepo equipesRepo;
    private EquipesMapper equipesMapper;
    public EquipesService(EquipesRepo equipesRepo, EquipesMapper equipesMapper) {
        this.equipesRepo = equipesRepo;
        this.equipesMapper = equipesMapper;
    }
    public ResponseDtoEquipe CreateEquipe(RequestDtoEquipe requestDtoEquipe) {
        Equipe saved =equipesRepo.save(equipesMapper.toEntity(requestDtoEquipe));
        ResponseDtoEquipe respone = equipesMapper.toDto(saved);
        return respone;

    }
    public List<ResponseDtoEquipe> getAllEquipes() {
        return equipesRepo.findAll().stream().map(equipesMapper::toDto).collect(Collectors.toList());
    }
    public ResponseDtoEquipe Update (RequestDtoEquipe requestDtoEquipe, int id) {
        Equipe equipe = equipesRepo.findById(id).orElseThrow(()-> new RuntimeException("Equipe not found"));
        if(requestDtoEquipe.getCode()!=null) equipe.setCode(requestDtoEquipe.getCode());
        if(requestDtoEquipe.getLibelle()!=null) equipe.setLibelle(requestDtoEquipe.getLibelle());
        equipesRepo.save(equipe);
        ResponseDtoEquipe respone = equipesMapper.toDto(equipe);
        return respone;

}
public void Delete (int id) {
        equipesRepo.deleteById(id);
}
public ResponseDtoEquipe GetEquipebyid (int id) {
        Equipe equipe=equipesRepo.findById(id).orElseThrow(()-> new RuntimeException("Equipe not found"));
        ResponseDtoEquipe respone = equipesMapper.toDto(equipe);
        return respone;
}

}
