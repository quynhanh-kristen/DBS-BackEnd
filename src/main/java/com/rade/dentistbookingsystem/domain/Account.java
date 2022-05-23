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
@Table(name ="Account")
public class Account  implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String full_name;
    @Temporal(TemporalType.DATE)
    private Date date_of_birth;
    @Column(nullable = false)
    private int gender;
    @Column(nullable = false)
    private int district_id;
    @Column(length = 10)
    private String phone;
    @Column(length = 50)
    private String email;
    @Column(nullable = false)
    private short status;

}
