package com.rade.dentistbookingsystem.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AccountNotificationKey implements Serializable {
    @Column(name = "account_id")
    int account_id;

    @Column(name = "notification_id")
    int notification_id;

}
