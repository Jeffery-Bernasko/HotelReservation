package com.example.reservation.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.example.reservation.model.Reservation}
 */
@Value
public class ReservationDto implements Serializable {
    Integer roomId;
    Integer guestId;
    LocalDate date;
}