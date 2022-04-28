package com.example.demo.Service;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import com.example.demo.Model.Reservation;

import org.springframework.stereotype.Service;

@Service
public interface ReservationService {
    public abstract void createReservation(Reservation reservation);
    public abstract void updateReservation(Integer id, Reservation reservation);
    public abstract void deleteReservation(Integer id);
    public abstract Collection<Reservation> getReservations();
    public abstract Collection<Reservation> getFilteredReservations(String filterType, String filter);
    public abstract Collection<Reservation> getAvailableFilteredReservations(String filterType, String filter);
    public abstract Object getFreeRooms();
    public abstract Object getRoomsWithJaccuzi() throws FileNotFoundException, IOException;
    public abstract Object getRoomsWithService() throws FileNotFoundException, IOException;
}
