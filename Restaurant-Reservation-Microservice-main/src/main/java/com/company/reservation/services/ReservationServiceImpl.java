package com.company.reservation.services;

import com.company.reservation.domain.Reservation;
import com.company.reservation.repository.ReservationRepository;
import com.company.reservation.web.controllers.NotFoundException;
import com.company.reservation.web.mappers.ReservationMapper;
import com.company.reservation.web.models.ReservationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j //for logging
public class ReservationServiceImpl implements ReservationService {

   private final ReservationRepository reservationRepository;
   private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public List<Reservation> getAllReservations() {
        log.info("find all reservation through service impl");
        return reservationRepository.findAll();
    }

    @Override
    public ReservationDto getById(Long id) {
        log.info("get reservation by id through service impl");
        return reservationMapper.reservationToReservationDto(reservationRepository.findById(id)
                .orElseThrow(NotFoundException::new)) ;
    }

    @Override
    public ReservationDto saveNewReservation(ReservationDto reservationDto) {
        log.info("saving new reservation through service impl");
        return reservationMapper.reservationToReservationDto(reservationRepository.save(reservationMapper.reservationDtoToReservation(reservationDto)));
    }

    @Override
    public ReservationDto updateReservation(Long id, ReservationDto reservationDto) {
        log.info("updating reservation through service impl");
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        reservation.setPartySize(reservationDto.getPartySize());
        reservation.setDate(reservationDto.getDate());
        reservation.setRestaurantName(reservationDto.getRestaurantName());
        reservation.setUserName(reservationDto.getUserName());

        return reservationMapper.reservationToReservationDto(reservationRepository.save(reservation));
    }

    @Override
    public void deleteReservation(Long id) {
        log.info("delete reservation through impl");
        reservationRepository.deleteById(id);
    }
}
