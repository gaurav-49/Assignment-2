package com.company.reservation.web.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class ReservationDto {

    @Null
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String partySize;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private OffsetDateTime date;

    @NotNull
    private String restaurantName;

    public ReservationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPartySize() {
        return partySize;
    }

    public void setPartySize(String partySize) {
        this.partySize = partySize;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public ReservationDto(Long id, String userName, String partySize, OffsetDateTime date, String restaurantName) {
        this.id = id;
        this.userName = userName;
        this.partySize = partySize;
        this.date = date;
        this.restaurantName = restaurantName;
    }
}
