package com.salon.repository.impl;

import com.salon.domain.Appointment;
import org.springframework.data.repository.CrudRepository;


public interface AppointmentRepo extends CrudRepository<Appointment,Long> {
}
