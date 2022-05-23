package com.rade.dentistbookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class DoctorBranchDTO implements Serializable {
    private int id;
    private int branch_id;
    private int doctor_id;
    private Date start_date;
    private int status;
}
