package org.example.equipe.Mapper;

import org.example.equipe.DTO.RequestDtoEquipe;
import org.example.equipe.DTO.ResponseDtoEquipe;
import org.example.equipe.Entities.Equipe;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EquipesMapper {
    public Equipe toEntity(RequestDtoEquipe requestDtoEquipe) {
        Equipe equipe = new Equipe();
        BeanUtils.copyProperties(requestDtoEquipe, equipe);
        return equipe;
    }
    public ResponseDtoEquipe toDto(Equipe equipe) {
        ResponseDtoEquipe responseDtoEquipe = new ResponseDtoEquipe();
        BeanUtils.copyProperties(equipe, responseDtoEquipe);
        return responseDtoEquipe;
    }
}
