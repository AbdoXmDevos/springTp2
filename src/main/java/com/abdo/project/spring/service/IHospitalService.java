package com.abdo.project.spring.service;

import com.abdo.project.spring.entites.*;


public interface IHospitalService {
    Patient savePatient(Patient p );
    Medecin saveMedecin(Medecin m);
    RendezVous saveRendezVous(RendezVous rv);
    Consultation saveConsultation(Consultation c);

    Patient findPatientById(Long id);
    RendezVous findRendezVousbyId(Long id);
    Medecin findMedecinbyId(Long id);







}
