package com.example.reservation.service;

import com.example.reservation.dto.GuestDto;
import com.example.reservation.model.Guest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GuestService {
    List<Guest> findAll();

    Guest findById(Long id);

    Guest save(GuestDto guest);
}
