package com.abdo.project.spring.repository;

import com.abdo.project.spring.entites.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {

        Medecin findByNom(String nom);

}
