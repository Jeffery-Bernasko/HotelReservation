package com.example.reservation.serviceImpl;

import com.example.reservation.dto.ReservationDto;
import com.example.reservation.model.Guest;
import com.example.reservation.model.Reservation;
import com.example.reservation.model.Room;
import com.example.reservation.model.RoomReservation;
import com.example.reservation.repository.GuestRepository;
import com.example.reservation.repository.ReservationRepository;
import com.example.reservation.repository.RoomRepository;
import com.example.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;



    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation save(ReservationDto reservation) {
        Reservation reservation1 = new Reservation();

        reservation1.setRoomId(reservation.getRoomId());
        reservation1.setGuestId(reservation.getGuestId());
        reservation1.setDate(reservation.getDate());

        return reservationRepository.save(reservation1);
    }

    public Reservation getById(Long id) {
        return reservationRepository.findById(id).get();
    }

    public void deleteReservation(Long id) {
        // check if room reservation exist then delete
        boolean checkReservation = reservationRepository.existsById(id);

        if(checkReservation){
            reservationRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Reservation does not exist");
        }
    }
}
