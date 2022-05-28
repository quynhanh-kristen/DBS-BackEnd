package com.rade.dentistbookingsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Account")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "password", length = 30)
    private String password;

    @Column(name = "full_name", nullable = false, columnDefinition = "nvarchar(30)")
    private String full_name;

    @Column(name = "date_of_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date_of_birth;

    @Column(name = "gender", nullable = false)
    private int gender;

    @Column(name = "phone", length = 10)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;


    @Column(name = "status", nullable = false)
    private short status;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Appointment> appointmentSet;
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Discount> discountSet;

    // account notification
    @OneToMany(mappedBy = "account")
    private Set<AccountNotification> accountNotificationSet;

    // account vs feedback
    @OneToMany(mappedBy = "account")
    private Set<Feedback> feedbackSet;
}
