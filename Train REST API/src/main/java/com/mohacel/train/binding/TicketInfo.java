package com.mohacel.train.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketInfo {
    private Integer ticketId;
    private String trainName;
    private Integer seatNumber;

}
