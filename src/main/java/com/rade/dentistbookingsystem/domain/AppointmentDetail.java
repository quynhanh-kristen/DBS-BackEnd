package com.rade.dentistbookingsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Appointment_Detail")
public class AppointmentDetail implements Serializable {
    @EmbeddedId
    private AppointmentDetailKey id;

    @ManyToOne
    @MapsId("service_id")
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne
    @MapsId("appointment_id")
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne()
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne()
    @JoinColumn(name = "discount_id")
    private Discount discount;
}
