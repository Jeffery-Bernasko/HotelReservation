package com.example.reservation.serviceImpl;

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

    public List<RoomReservation> getRoomReservationsForDate(Date date){
        // Iterate through Room model and find all rooms
        Iterable<Room> rooms = roomRepository.findAll();

        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();

        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });
        Iterable<Reservation> reservations = reservationRepository.findReservationByDate(new java.sql.Date(date.getTime()).toLocalDate());
        if(null != reservations){
            reservations.forEach(reservation -> {
                Guest guest = guestRepository.findById(reservation.getId()).get();
                RoomReservation roomReservation = roomReservationMap.get(reservation.getId());
                roomReservation.setDate(date);
                roomReservation.setFirstName(guest.getFirstName());
                roomReservation.setLastName(guest.getLastName());
                roomReservation.setGuestId(guest.getId());
            });
        }
        List<RoomReservation> roomReservations = new ArrayList<>();
        for(Long roomId: roomReservationMap.keySet()){
            roomReservations.add(roomReservationMap.get(roomId));
        }
        return roomReservations;
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
