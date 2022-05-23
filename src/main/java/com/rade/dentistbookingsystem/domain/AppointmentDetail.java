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
public class AppointmentDetail  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int booking_id;
    @Column(nullable = false)
    private int service_id;
    @Column(nullable = false)
    private int doctor_id;
    @Column(nullable = false)
    private int discount_id;

}
