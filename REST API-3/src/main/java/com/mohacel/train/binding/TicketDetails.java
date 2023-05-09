package com.mohacel.train.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDetails {
    private String id = UUID.randomUUID().toString();
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate journeyDate;
    private String trainName;
    private String from;
    private String to;
    private SeatType seatType;

    public void setJourneyDate(String dateStr) {
        this.journeyDate = LocalDate.parse(dateStr);
    }
}
