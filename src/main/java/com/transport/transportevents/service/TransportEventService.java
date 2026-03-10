package com.transport.transportevents.service;

import com.transport.transportevents.entity.TransportEvent;
import com.transport.transportevents.repository.TransportEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TransportEventService {

    // Stores a reference to the repostory so the service can call it to perform database operations
    private final TransportEventRepository transportEventRepository;

    // passess the repository into the service called dependency injection
    public TransportEventService(TransportEventRepository transportEventRepository) {
        this.transportEventRepository = transportEventRepository;
    }

    // return a list of all transport events in the database
    public List<TransportEvent> getAllEvents() {
        return transportEventRepository.findAll();
    }

    // returns an optional transport event by its ID, if it exists in the database
    public Optional<TransportEvent> getEventById(Long id) {
        return transportEventRepository.findById(id);
    }

    // returns a list of transport events associated with a specific patient ID
    public List<TransportEvent> getEventsByPatientId(String patientId) {
        return transportEventRepository.findByPatientId(patientId);
    }

    // returns the saved transport event after saving it to the database using the repository's save method
    public TransportEvent createEvent(TransportEvent event) {
        return transportEventRepository.save(event);
    }
}
