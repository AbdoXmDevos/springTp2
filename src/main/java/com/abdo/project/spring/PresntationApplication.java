package com.abdo.project.spring;

import com.abdo.project.spring.entites.*;
import com.abdo.project.spring.repository.RendezVousRepository;
import com.abdo.project.spring.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PresntationApplication {



	public static void main(String[] args) {
		SpringApplication.run(PresntationApplication.class, args);
	}
	// Au démarrage Spring appele la méthode start() ,
	// et start va retourner un object de type CommandLineRunner
	// le code qu'on va implementer au niveau de start() ,
	// elle va s'executer au niveau de démarrage
	@Bean
	CommandLineRunner start(IHospitalService iHospitalService,RendezVousRepository rendezVousRepository){
		return args -> {
			Stream.of("Abdo","Karimi")
					.forEach(name ->{
						Patient patient = new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						iHospitalService.savePatient(patient);
					});
			Stream.of("Med1","Med2","me3")
					.forEach(name ->{
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setEmail("meds@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"General");
						iHospitalService.saveMedecin(medecin);
					});

			Patient patient = iHospitalService.findPatientById(2L);
			Medecin medecin = iHospitalService.findMedecinbyId(1L);
			//Patient patient1 =patientRepository.findByNom("Manna");
			//Medecin medecin = medecinRepository.findByNom("Med1");
			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.CANCELED);
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			iHospitalService.saveRendezVous(rendezVous);

			//RendezVous rendezVous1 = iHospitalService.findRendezVousbyId(1L);
			RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport2");
			iHospitalService.saveConsultation(consultation);

		};


	}
}
