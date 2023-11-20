package com.example.reservation.service;

import com.example.reservation.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();

    Room findById(Long roomId);
}
