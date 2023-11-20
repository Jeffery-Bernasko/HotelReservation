package com.example.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomReservation {
    private Long roomId;

    private Long guestId;

    private String roomName;

    private String roomNumber;

    private String firstName;

    private String lastName;

    private Date date;
}
