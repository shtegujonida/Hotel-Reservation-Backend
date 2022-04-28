package com.example.demo.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.Model.Reservation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static Map<Integer, Reservation> reservations = new HashMap<Integer, Reservation>();
    private AtomicLong counter = new AtomicLong();

    //The class constructor which reads data from CSV file
    public ReservationServiceImpl() {
        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Reservation reservation = new Reservation((int) counter.incrementAndGet(),
                        Integer.parseInt(values[0]), Integer.parseInt(values[1]),
                        Integer.parseInt(values[2]), Integer.parseInt(values[3]),
                        Boolean.parseBoolean(values[4]), Boolean.parseBoolean(values[5]),
                        values[6], values[7], Boolean.parseBoolean(values[8]),
                        values[9]);
                reservations.put(counter.intValue(), reservation);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Method used to add new reservation 

    @Override
    public void createReservation(Reservation reservation) {
        if (reservations.containsKey(reservation.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reservation already exists");
        reservations.put(reservation.getId(), reservation);

    }

    //Method used to change data of an existing reservation based on id

    @Override
    public void updateReservation(Integer id, Reservation reservation) {
        reservations.remove(id);
        reservation.setId(id);
        reservations.put(reservation.getId(), reservation);

    }

    //Method used to delete a reservation based on id

    @Override
    public void deleteReservation(Integer id) {
        reservations.remove(id);

    }

    //Method used to get all the existing reservations in json format

    @Override
    public Collection<Reservation> getReservations() {
        return reservations.values();
    }

    //Method used to filter only the free rooms

    @Override
    public Collection<Reservation> getFreeRooms() {
        Map<Integer, Reservation> availableRooms = new HashMap<Integer, Reservation>();
        AtomicLong counter = new AtomicLong();

        for (Map.Entry<Integer, Reservation> el : reservations.entrySet()) {
            if (el.getValue().getFree().toString().equals("true"))
                availableRooms.put((int) counter.incrementAndGet(), el.getValue());
        }

        return availableRooms.values();
    }

    //Method used to filter only the rooms that provide room-service

    @Override
    public Collection<Reservation> getRoomsWithService() throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        Map<Integer, Reservation> availableRooms = new HashMap<Integer, Reservation>();
        AtomicLong counter = new AtomicLong();

        for (Map.Entry<Integer, Reservation> el : reservations.entrySet()) {
            if (el.getValue().getRoomService().toString().equals("true"))
                availableRooms.put((int) counter.incrementAndGet(), el.getValue());
        }
        return availableRooms.values();
    }

    //Method used to filter only the rooms that provide jaccuzi
    @Override
    public Collection<Reservation> getRoomsWithJaccuzi() throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
        Map<Integer, Reservation> availableRooms = new HashMap<Integer, Reservation>();
        AtomicLong counter = new AtomicLong();

        for (Map.Entry<Integer, Reservation> el : reservations.entrySet()) {
            if (el.getValue().getJaccuzi().toString().equals("true"))
                availableRooms.put((int) counter.incrementAndGet(), el.getValue());
        }
        return availableRooms.values();
    }


    //Method used to get an array with reservations filtered from the frontend

    @Override

    public Collection<Reservation> getFilteredReservations(String filterType, String filter) {
        Map<Integer, Reservation> filteredReservations = new HashMap<Integer, Reservation>();
        AtomicLong counter = new AtomicLong();

        switch(filterType) {
            case "jacuzzi": for(Map.Entry<Integer, Reservation> el : reservations.entrySet()) {
                if(el.getValue().getJaccuzi())
                filteredReservations.put((int)counter.incrementAndGet(), el.getValue());
                } break;

            case "room-service": for(Map.Entry<Integer, Reservation> el : reservations.entrySet()) {
                    if(el.getValue().getRoomService())
                    filteredReservations.put((int)counter.incrementAndGet(), el.getValue());
                } break;
            
            default: System.out.println("Unknown value");


        }
        return filteredReservations.values();
    }

    //Method used to get an array with reservations filtered from the frontend, and are also free rooms

    @Override

    public Collection<Reservation> getAvailableFilteredReservations(String filterType, String filter) {
        Map<Integer, Reservation> filteredReservations = new HashMap<Integer, Reservation>();
        AtomicLong counter = new AtomicLong();

        switch(filterType) {
            case "jacuzzi": for(Map.Entry<Integer, Reservation> el : reservations.entrySet()) {
                if(el.getValue().getJaccuzi() && el.getValue().getFree())
                filteredReservations.put((int)counter.incrementAndGet(), el.getValue());
            } break;

            case "room-service": for(Map.Entry<Integer, Reservation> el : reservations.entrySet()) {
                if(el.getValue().getRoomService() && el.getValue().getFree())
                filteredReservations.put((int)counter.incrementAndGet(), el.getValue());
            } break;
            
            default: System.out.println("Unknown value");

        }

        return filteredReservations.values();
    }
}