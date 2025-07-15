package com.medsecure.controller;

import com.medsecure.model.Medication;
import com.medsecure.service.MedicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping
    public List<Medication> getAll() {
        // TODO: Call medicationService.getAllMedications() and return the result
        return null;
    }
}
