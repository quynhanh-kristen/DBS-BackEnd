package com.rade.dentistbookingsystem.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class AppointmentDetailKey implements Serializable {
    @Column(name = "service_id")
    private int service_id;

    @Column(name = "appointment_id")
    private int appointment_id;

}
