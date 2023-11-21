package com.example.reservation.controller;

import com.example.reservation.dto.GuestDto;
import com.example.reservation.model.Guest;
import com.example.reservation.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest")
public class GuestController {
    private final GuestService guestService;

    //Get all List of guest
    @GetMapping()
    public List<Guest> getAllGuest(){
        return guestService.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable Long id){
        return guestService.findById(id);
    }

    @PostMapping()
    public Guest postAndSaveGuest(@RequestBody GuestDto guest){
        return guestService.save(guest);
    }

}
