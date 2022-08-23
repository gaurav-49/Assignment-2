package com.company.reservation.web.mappers;

import com.company.reservation.domain.Reservation;
import com.company.reservation.web.models.ReservationDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-21T21:58:05+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4 (Amazon.com Inc.)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ReservationDto reservationToReservationDto(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setId( reservation.getId() );
        reservationDto.setUserName( reservation.getUserName() );
        reservationDto.setPartySize( reservation.getPartySize() );
        reservationDto.setDate( reservation.getDate() );
        reservationDto.setRestaurantName( reservation.getRestaurantName() );

        return reservationDto;
    }

    @Override
    public Reservation reservationDtoToReservation(ReservationDto reservationDto) {
        if ( reservationDto == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setId( reservationDto.getId() );
        reservation.setUserName( reservationDto.getUserName() );
        reservation.setPartySize( reservationDto.getPartySize() );
        reservation.setDate( reservationDto.getDate() );
        reservation.setRestaurantName( reservationDto.getRestaurantName() );

        return reservation;
    }
}
