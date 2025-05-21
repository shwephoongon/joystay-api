package com.shwephoo.joystay_api.repository;

import com.shwephoo.joystay_api.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {}
