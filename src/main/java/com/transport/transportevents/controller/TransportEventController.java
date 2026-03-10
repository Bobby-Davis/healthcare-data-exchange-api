package com.transport.transportevents.controller;

import com.transport.transportevents.entity.TransportEvent;
import com.transport.transportevents.service.TransportEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transport-events")
public class TransportEventController {

    private final TransportEventService transportEventService;

    public TransportEventController(TransportEventService transportEventService) {
        this.transportEventService = transportEventService;
    }

    @GetMapping
    public List<TransportEvent> getAllEvents() {
        return transportEventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public TransportEvent getEventById(@PathVariable Long id) {
        return transportEventService.getEventById(id).orElse(null);
    }

    @GetMapping("/patient/{patientId}")
    public List<TransportEvent> getEventsByPatientId(@PathVariable String patientId) {
        return transportEventService.getEventsByPatientId(patientId);
    }

    @PostMapping
    public TransportEvent createEvent(@RequestBody TransportEvent event) {
        return transportEventService.createEvent(event);
    }


    
}
