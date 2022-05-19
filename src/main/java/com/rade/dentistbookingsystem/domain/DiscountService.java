package com.rade.dentistbookingsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Discount_Service")
@IdClass(DiscountServiceCompositeID.class)
public class DiscountService  implements Serializable {
    @Id
    private int service_id;
    @Id
    private int discount_id;
}
