package com.rade.dentistbookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDTO implements Serializable {
    private int id;
    @NotEmpty
    private int name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String url;
    @NotEmpty
    private int branch_id;
}
