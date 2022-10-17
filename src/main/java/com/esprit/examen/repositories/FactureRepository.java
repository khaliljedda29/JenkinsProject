package com.esprit.examen.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esprit.examen.entities.Facture;


@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
	
}
