package com.rade.dentistbookingsystem.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DiscountServiceKey implements Serializable {
    @Column(name = "service_id")
    private int service_id;

    @Column(name = "discount_id")
    private int discount_id;
}
