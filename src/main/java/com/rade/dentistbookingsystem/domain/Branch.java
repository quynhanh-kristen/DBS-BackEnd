package com.rade.dentistbookingsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Branch")
public class Branch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition = "nvarchar(30)")
    private String name;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    @Column(nullable = false, columnDefinition = "varchar(MAX)")
    private String url;


    @Column(name = "open_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date open_time;

    @Column(name = "close_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date close_time;


    @Column(nullable = false)
    private int status;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    Set<Appointment> appointmentSet;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    Set<Doctor> doctorSet;


}
