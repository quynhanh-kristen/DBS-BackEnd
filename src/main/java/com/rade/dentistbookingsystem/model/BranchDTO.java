package com.rade.dentistbookingsystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BranchDTO  implements Serializable {
    private int id;
    private String name;

    private int district_id;

    private String url;

    private String open_time;

    private String close_time;

    private Integer status;
}
