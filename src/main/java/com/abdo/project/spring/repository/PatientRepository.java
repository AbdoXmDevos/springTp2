package com.abdo.project.spring.repository;

import com.abdo.project.spring.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

// ça c'est SpringDATA
public interface PatientRepository extends JpaRepository<Patient,Long> {
    //List<Patient> findPatientByNom(String nom);
    Patient findByNom(String name);


}
