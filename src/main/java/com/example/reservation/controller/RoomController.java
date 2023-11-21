package com.example.reservation.controller;


import com.example.reservation.dto.RoomDto;
import com.example.reservation.model.Room;
import com.example.reservation.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    @GetMapping()
    public List<Room> findAllRooms(){
        return roomService.findAll();
    }
@GetMapping("/{id}")
    public Room findById(@PathVariable Long id){
        return roomService.findById(id);
    }

    // A POST request to send a room payload(Data) and save
    @PostMapping()
    public Room postAndSaveRoom(@RequestBody RoomDto room){
        return roomService.save(room);
    }
}
