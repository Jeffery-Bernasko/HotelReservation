package com.example.reservation.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.reservation.model.Guest}
 */
@Value
public class GuestDto implements Serializable {
    String firstName;
    String lastName;
    String email;
    String address;
    String country;
    String city;
    String phoneNumber;
}