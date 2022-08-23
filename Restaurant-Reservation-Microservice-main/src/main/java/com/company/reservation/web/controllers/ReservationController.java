package com.company.reservation.web.controllers;

import com.company.reservation.domain.Reservation;
import com.company.reservation.services.ReservationService;
import com.company.reservation.web.models.ReservationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@Slf4j
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/get/v1/reservations")
    public List<Reservation> getAllReservations(){
        log.info("printing all reservations in the DB, currently in controller");
        return reservationService.getAllReservations();
    }

    @GetMapping("get/v1/reservation/{id}")
    public ResponseEntity getReservationById(@PathVariable("id") Long id){
        log.info("getting a reservation by id, currently in controller");

        return new ResponseEntity<>(reservationService.getById(id), HttpStatus.OK);
    }

    @PostMapping("post/v1/reservations")
    public ResponseEntity createNewReservation(@RequestBody ReservationDto reservationDto){
        log.info("creating a new reservation, in controller");
        return new ResponseEntity<>(reservationService.saveNewReservation(reservationDto), HttpStatus.CREATED);
    }

    @PutMapping("put/v1/update/{id}")
    public ResponseEntity updateReservation(@PathVariable("id") Long id, @RequestBody ReservationDto reservationDto){
        log.info("updating a reservation, currently in controller");
        return new ResponseEntity<>(reservationService.updateReservation(id, reservationDto), HttpStatus.OK);
    }

    @DeleteMapping("delete/v1/reservation/{id}")
    public ResponseEntity deleteReservation(@PathVariable("id") Long id){
        log.info("deleting a reservation currently in controller");
        reservationService.deleteReservation(id);
        return new ResponseEntity<String>("Reservation Deleted", HttpStatus.OK);
    }



}
