package com.mohacel.train.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatType {
    private String type;
    private Integer seatNumber;
}
