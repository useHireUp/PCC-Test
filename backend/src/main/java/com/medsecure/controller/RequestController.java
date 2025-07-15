package com.medsecure.controller;

import com.medsecure.model.Request;
import com.medsecure.service.RequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public Request submitRequest(@RequestBody Request request) {
        // TODO: Call requestService.createRequest(request) and return the result
        return null;
    }

    @GetMapping
    public List<Request> getAll() {
        // TODO: Call requestService.getAllRequests() and return the result
        return null;
    }
}
