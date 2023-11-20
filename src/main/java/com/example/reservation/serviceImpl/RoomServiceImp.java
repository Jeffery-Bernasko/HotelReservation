package com.example.reservation.serviceImpl;

import com.example.reservation.model.Room;
import com.example.reservation.repository.RoomRepository;
import com.example.reservation.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImp implements RoomService {
    private final RoomRepository roomRepository;

    public List<Room> findAll(){
        return roomRepository.findAll();
    }

    public Room findById(Long roomId) {
        return roomRepository.findById(roomId).get() ;
    }
}
