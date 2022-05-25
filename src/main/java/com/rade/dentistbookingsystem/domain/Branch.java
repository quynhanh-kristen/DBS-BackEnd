package com.rade.dentistbookingsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

    @Column(nullable = false, columnDefinition = "nvarchar(30)", unique = true)
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
    private Set<Appointment> appointmentSet;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private Set<Doctor> doctorSet;

    public Branch(String name, District byId, Date open_time, Date close_time, int status, String url) {
        this.name = name;
        this.district = byId;
        this.url = url;
        this.open_time = open_time;
        this.close_time = close_time;
        this.status = status;
    }
}
