package com.rade.dentistbookingsystem.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AppointmentDetailKey implements Serializable {
    @Column(name = "service_id")
    int service_id;

    @Column(name = "booking_id")
    int booking_id;

}
