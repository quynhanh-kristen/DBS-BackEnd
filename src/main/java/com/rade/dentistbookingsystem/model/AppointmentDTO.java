package com.rade.dentistbookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentDTO implements Serializable {
    private int id;
    private int account_id;
    private int branch_id;
    private String name;
    private String phone;
    private Date date;
    private int status;
}
