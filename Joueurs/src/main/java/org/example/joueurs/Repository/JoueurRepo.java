package org.example.joueurs.Repository;

import org.example.joueurs.Entities.Joueurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoueurRepo  extends JpaRepository<Joueurs,Integer> {
    @Query ("SELECT COUNT(c) FROM Joueurs c  where  c.responsable_id= :id_responsable order by c.nombrebut desc ")
    List<Joueurs> findOrderByNombrebutDesc(@Param("id_responsable") int  id_responsable);
}