package com.example.reservation.service;

import com.example.reservation.model.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> findAll();
}
