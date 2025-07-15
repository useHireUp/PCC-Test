package com.medsecure.service;

import com.medsecure.model.Medication;
import com.medsecure.repository.MedicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public List<Medication> getAllMedications() {
        // TODO: Use medicationRepository.findAll() and return the result
        return null;
    }

    public Medication getMedicationById(Long id) {
        // TODO: Use medicationRepository.findById(id) and return the result
        return null;
    }

    public Medication createMedication(Medication medication) {
        // TODO: Use medicationRepository.save(medication) and return the result
        return null;
    }
}