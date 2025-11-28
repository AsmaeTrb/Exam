package org.example.equipe.Repository;

import org.example.equipe.Entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface EquipesRepo extends JpaRepository<Equipe, Integer> {
}
