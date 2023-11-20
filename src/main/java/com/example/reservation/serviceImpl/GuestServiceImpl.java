package com.example.reservation.serviceImpl;

import com.example.reservation.model.Guest;
import com.example.reservation.repository.GuestRepository;
import com.example.reservation.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;
    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Guest findById(Long id) {
        return guestRepository.findById(id).get();
    }
}
