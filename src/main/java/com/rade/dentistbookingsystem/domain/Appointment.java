package com.rade.dentistbookingsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Appointment")
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = true)
    private Account account;

    @ManyToOne()
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @Column(name = "guest_name", columnDefinition = "nvarchar(30)")
    private String guest_name;

    @Column(name = "phone", length = 10)
    private String phone;

    @Column(name = "appointment_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "appointment_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date time;

    @Column(name = "status", nullable = false)
    private int status;
    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Set<AppointmentDetail> appointmentDetailSet;
}
