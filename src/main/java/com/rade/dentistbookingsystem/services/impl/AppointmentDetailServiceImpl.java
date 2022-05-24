package com.rade.dentistbookingsystem.services.impl;

import com.rade.dentistbookingsystem.repository.AppointmentDetailRepo;
import com.rade.dentistbookingsystem.services.AppointmentDetailService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentDetailServiceImpl implements AppointmentDetailService {
    AppointmentDetailRepo appointmentDetailRepo;

    public AppointmentDetailServiceImpl(AppointmentDetailRepo appointmentDetailRepo) {
        this.appointmentDetailRepo = appointmentDetailRepo;
    }
}
