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
@Table(name = "Feedback")
public class Feedback  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int service_id;
    @Column(nullable = false)
    private int account_id;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date time;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private int status;

}
