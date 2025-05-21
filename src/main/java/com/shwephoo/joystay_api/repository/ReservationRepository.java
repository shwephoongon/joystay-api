package com.shwephoo.joystay_api.repository;

import com.shwephoo.joystay_api.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {}