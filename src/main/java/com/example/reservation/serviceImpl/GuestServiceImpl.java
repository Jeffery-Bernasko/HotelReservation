package com.example.reservation.serviceImpl;

import com.example.reservation.dto.GuestDto;
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

    public Guest save(GuestDto guest) {
        Guest guest1 = new Guest();

        guest1.setFirstName(guest.getFirstName());
        guest1.setLastName(guest.getLastName());
        guest1.setEmail(guest.getEmail());
        guest1.setCity(guest.getCity());
        guest1.setCountry(guest.getCountry());
        guest1.setPhoneNumber(guest.getPhoneNumber());
        guest1.setAddress(guest.getAddress());

        return guestRepository.save(guest1);
    }

    public void deleteGuest(Long id) {
        boolean checkGuest = guestRepository.existsById(id);

        if(checkGuest){
            guestRepository.deleteById(id);
        }else {
            throw new IllegalStateException("Guest does not exist");
        }
    }
}
