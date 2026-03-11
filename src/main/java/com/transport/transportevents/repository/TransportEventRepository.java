package com.transport.transportevents.repository;

import com.transport.transportevents.entity.TransportEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportEventRepository extends JpaRepository<TransportEvent, Long> {

    // find events by patient ID
    List<TransportEvent> findByPatientId(String patientId);
}