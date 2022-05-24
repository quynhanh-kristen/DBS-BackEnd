package com.rade.dentistbookingsystem.repository;

import com.rade.dentistbookingsystem.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
}
