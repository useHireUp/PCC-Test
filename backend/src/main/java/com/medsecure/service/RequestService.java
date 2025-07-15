package com.medsecure.service;

import com.medsecure.model.Request;
import com.medsecure.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<Request> getAllRequests() {
        // TODO: Use requestRepository.findAll() and return the result
        return null;
    }

    public Request getRequestById(Long id) {
        // TODO: Use requestRepository.findById(id) and return the result
        return null;
    }

    public Request createRequest(Request request) {
        // TODO: Use requestRepository.save(request) and return the result
        return null;
    }

    public List<Request> getRequestsByPatientId(String patientId) {
        // TODO: Use requestRepository.findByPatientId(patientId) and return the result
        return null;
    }
}