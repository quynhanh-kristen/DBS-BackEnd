package com.rade.dentistbookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceDTO  implements Serializable {
    private int id;
    private int service_type_id;
    private String name;
    private String description;
    private int status;
    private float min_price;
    private float max_price;

}
