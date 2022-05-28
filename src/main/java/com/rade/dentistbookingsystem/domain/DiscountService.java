package com.rade.dentistbookingsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.EmbeddedId;
import javax.persistence.MapsId;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Discount_Service")

public class DiscountService implements Serializable {
    @EmbeddedId
    private DiscountServiceKey id;

    @ManyToOne
    @MapsId("service_id")
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne
    @MapsId("discount_id")
    @JoinColumn(name = "discount_id")
    private Discount discount;
}
