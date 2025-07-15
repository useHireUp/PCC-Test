package com.medsecure.repository;

import com.medsecure.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    
    // TODO: Implement this method to find requests by patient ID
    List<Request> findByPatientId(String patientId);
}
