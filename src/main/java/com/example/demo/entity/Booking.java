package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String passengerName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.PENDING;

    // Σχέση Many-to-One: Πολλές κρατήσεις ανήκουν σε μία διαδρομή
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    // Enum για την κατάσταση της κράτησης
    public enum BookingStatus {
        PENDING,
        CONFIRMED,
        CANCELLED
    }

    // Constructors
    public Booking() {}

    public Booking(String passengerName, Route route) {
        this.passengerName = passengerName;
        this.route = route;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }

    public Route getRoute() { return route; }
    public void setRoute(Route route) { this.route = route; }
}