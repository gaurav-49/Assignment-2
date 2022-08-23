package com.company.reservation.services;

import com.company.reservation.domain.Reservation;
import com.company.reservation.web.models.ReservationDto;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations();

    ReservationDto getById(Long id);

    ReservationDto saveNewReservation(ReservationDto reservationDto);

    ReservationDto updateReservation(Long id, ReservationDto reservationDto);

    void deleteReservation(Long id);


}
