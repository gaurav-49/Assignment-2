package com.company.reservation.web.mappers;

import com.company.reservation.domain.Reservation;
import com.company.reservation.web.models.ReservationDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(uses = {DateMapper.class})
public interface ReservationMapper {
    ReservationDto reservationToReservationDto(Reservation reservation);
    Reservation reservationDtoToReservation(ReservationDto reservationDto);
}
