package com.transport.transportevents.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="transport_events")
public class TransportEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_type")
    private String eventType;
    
    @Column(name = "source_system")
    private String sourceSystem;

    @Column(name = "destination_system")
    private String destinationSystem;

    private String status;

    @Column(name = "message_id")
    private String messageId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "document_loinc_code")
    private String documentLoincCode;

    @Column(name = "source_oid")
    private String sourceOid;

    @Column(name = "destination_oid")
    private String destinationOid;

    public TransportEvent() {}

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getDestinationSystem() {
        return destinationSystem;
    }

    public void setDestinationSystem(String destinationSystem) {
        this.destinationSystem = destinationSystem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDocumentLoincCode() {
        return documentLoincCode;
    }

    public void setDocumentLoincCode(String documentLoincCode) {
        this.documentLoincCode = documentLoincCode;
    }

    public String getSourceOid() {
        return sourceOid;
    }

    public void setSourceOid(String sourceOid) {
        this.sourceOid = sourceOid;
    }

    public String getDestinationOid() {
        return destinationOid;
    }

    public void setDestinationOid(String destinationOid) {
        this.destinationOid = destinationOid;
    }

}
