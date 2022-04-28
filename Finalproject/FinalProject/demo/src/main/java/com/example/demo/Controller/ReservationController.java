package com.example.demo.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.demo.Model.Reservation;
import com.example.demo.Service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public ResponseEntity<Object> getReservations() throws FileNotFoundException, IOException {
        return new ResponseEntity<>(reservationService.getReservations(), HttpStatus.OK);
        
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/reservations/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteReservation(@PathVariable("id") Integer id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>("Reservation has been deleted.", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/reservations/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateReservation(@PathVariable("id") Integer id, @RequestBody Reservation reservation) {
        reservationService.updateReservation(id, reservation);
        return new ResponseEntity<>("Reservation has been updated successfully", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/reservations", method = RequestMethod.POST)
    public ResponseEntity<Object> createReservation(@RequestBody Reservation reservation) {
        reservationService.createReservation(reservation);
        return new ResponseEntity<>("Reservation has been added successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reservations/available", method = RequestMethod.GET)
    public ResponseEntity<Object> getFreeRooms() throws FileNotFoundException, IOException {
        return new ResponseEntity<>(reservationService.getFreeRooms(), HttpStatus.OK);
    }

    @RequestMapping(value="reservations/jaccuzi", method=RequestMethod.GET)
    public ResponseEntity<Object> getRoomsWithJaccuzi() throws FileNotFoundException, IOException{
        return new ResponseEntity<>(reservationService.getRoomsWithJaccuzi(), HttpStatus.OK);
    }

    @RequestMapping(value="reservations/withService", method=RequestMethod.GET)
    public ResponseEntity<Object> getRoomsWithService() throws FileNotFoundException, IOException{
        return new ResponseEntity<>(reservationService.getRoomsWithService(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/reservations/{filterType}/{filter}", method = RequestMethod.GET)
    public ResponseEntity<Object> getFilteredReservations(@PathVariable("filterType") String filterType,
            @PathVariable("filter") String filter) {
        return new ResponseEntity<>(reservationService.getFilteredReservations(filterType, filter), HttpStatus.OK);
    }

    @RequestMapping(value = "/reservations/available/{filterType}/{filter}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAvailableFilteredReservations(@PathVariable("filterType") String filterType,
            @PathVariable("filter") String filter) {
        return new ResponseEntity<>(reservationService.getAvailableFilteredReservations(filterType, filter), HttpStatus.OK);
    }

}