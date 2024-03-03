package com.abdo.project.spring.repository;

import com.abdo.project.spring.entites.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository  extends JpaRepository<Consultation,Long> {
}
