package com.example.reservation.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.reservation.model.Room}
 */
@Value
public class RoomDto implements Serializable {
    String name;
    String number;
    String bedInfo;
}