package com.example.reservation.serviceImpl;

import com.example.reservation.dto.RoomDto;
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

    public Room save(RoomDto roomDto) {
        Room room = new Room();

        //Set the attributes for the room
        room.setName(roomDto.getName());
        room.setNumber(roomDto.getNumber());
        room.setBedInfo(roomDto.getBedInfo());

        return roomRepository.save(room);
    }
}
