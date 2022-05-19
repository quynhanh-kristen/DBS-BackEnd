package com.rade.dentistbookingsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Appointment")
public class Appointment  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int account_id;
    @Column(nullable = false)
    private int branch_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 10)
    private String phone;
    @Temporal(TemporalType.DATE)
    private Date date;
}
