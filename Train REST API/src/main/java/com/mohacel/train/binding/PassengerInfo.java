package com.mohacel.train.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerInfo {
    private Integer passengerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate journeyDate;
    private String journeyFrom;
    private String journeyTo;

}
