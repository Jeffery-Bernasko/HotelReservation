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

    // Method to get all rooms
    public List<Room> findAll(){
        return roomRepository.findAll();
    }

    // Method to get room by using the id
    public Room findById(Long roomId) {
        return roomRepository.findById(roomId).get() ;
    }




    // Method to save a room entity
    public Room save(RoomDto roomDto) {
        Room room = new Room();

        //Set the attributes for the room
        room.setName(roomDto.getName());
        room.setNumber(roomDto.getNumber());
        room.setBedInfo(roomDto.getBedInfo());


        return roomRepository.save(room);
    }

    public void deleteRoomById(Long id) {
        //Check if room exist
        boolean roomExist = roomRepository.existsById(id);

        if(roomExist){
            roomRepository.deleteById(id);
        }else {
            throw new IllegalStateException("Room does not exist");
        }
    }


}
