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
@Table(name = "Discount")
public class Discount  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int account_id;
    @Column(nullable = false, length = 30, columnDefinition = "nvarchar(30)")
    private String name;
    @Column(nullable = false)
    private float percentage;
    @Column(columnDefinition = "nvarchar(MAX)")
    private String description;
    @Column(nullable = false)
    private int status;
    @Temporal(TemporalType.DATE)
    private Date start_date;
    @Temporal(TemporalType.DATE)
    private Date end_date;
}
