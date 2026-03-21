package com.transport.transportevents.controller;

import com.transport.transportevents.entity.TransportEvent;
import com.transport.transportevents.service.TransportEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transport-events")
public class TransportEventController {

    // TransportEventService is injected to handle the business logic of transport events
    private final TransportEventService transportEventService;

    
    // Constructor to initialize the TransportEventController with TransportEventService
    public TransportEventController(TransportEventService transportEventService) {
        this.transportEventService = transportEventService;
    }

    // GET all transport events, returns status 200 with the list of events in the response body
    @GetMapping
    public ResponseEntity<List<TransportEvent>> getAllEvents() {
        List<TransportEvent> events = transportEventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    // GET a transport event by its ID, returns 404 if the event is not found
    @GetMapping("/{id}")
    public ResponseEntity<TransportEvent> getEventById(@PathVariable Long id) {
        return transportEventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET transport events by patient ID, returns status 200 OK with matching events in the response body, or an empty list if none are found
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<TransportEvent>> getEventsByPatientId(@PathVariable String patientId) {
        List<TransportEvent> events = transportEventService.getEventsByPatientId(patientId);
        return ResponseEntity.ok(events);
    }

    // POST a new transport event, returns status 201 with the created event in the response body
    @PostMapping
    public ResponseEntity<TransportEvent> createEvent(@RequestBody TransportEvent event) {
        TransportEvent createdEvent = transportEventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }
    
}
