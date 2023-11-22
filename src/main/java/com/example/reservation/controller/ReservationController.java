package com.example.reservation.controller;

import com.example.reservation.dto.ReservationDto;
import com.example.reservation.model.Reservation;
import com.example.reservation.repository.ReservationRepository;
import com.example.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping()
    public List<Reservation> getAllReservation(){
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id){
        return reservationService.getById(id);
    }

    @PostMapping()
    public Reservation postAndSaveReservation(@RequestBody ReservationDto reservation){
        return reservationService.save(reservation);
    }


    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
    }
}
