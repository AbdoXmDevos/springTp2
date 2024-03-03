package com.abdo.project.spring.service;

import com.abdo.project.spring.entites.Consultation;
import com.abdo.project.spring.entites.Medecin;
import com.abdo.project.spring.entites.Patient;
import com.abdo.project.spring.entites.RendezVous;
import com.abdo.project.spring.repository.ConsultationRepository;
import com.abdo.project.spring.repository.MedecinRepository;
import com.abdo.project.spring.repository.PatientRepository;
import com.abdo.project.spring.repository.RendezVousRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class HospitalServiceImpl implements IHospitalService{
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;


    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin saveMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rv) {
        // pour generer des chaines de ch aléatoires et unique
        rv.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rv);
    }

    @Override
    public Consultation saveConsultation(Consultation c) {
        return consultationRepository.save(c);
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public RendezVous findRendezVousbyId(Long id) {
        return null ;
        //rendezVousRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin findMedecinbyId(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }




}
