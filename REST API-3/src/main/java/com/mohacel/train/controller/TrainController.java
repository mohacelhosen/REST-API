package com.mohacel.train.controller;

import com.mohacel.train.binding.SeatType;
import com.mohacel.train.binding.TicketDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.UUID;


@Controller
public class TrainController {
    TicketDetails myBooking = new TicketDetails();

    @PostMapping(value = "/booking", consumes = {"application/json","application/xml"})
    public ResponseEntity<String> seatBooking(@RequestBody TicketDetails train){
        System.out.println(train);
        myBooking = train;
        System.out.println("Your information received successfully..✅");
        String msg = "Record Inserted Successfully..✅";
        return  new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping(value = "/show", produces = {"application/json","application/xml"})
    public ResponseEntity<TicketDetails> getBooking(TicketDetails trainBooking){
        TicketDetails trainBooking1 = new TicketDetails();
        trainBooking1 = myBooking;
        return  new ResponseEntity<>(trainBooking1,HttpStatus.OK);
    }

    @PostMapping(value = "/bookTicket", produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public ResponseEntity<TicketDetails> getTicket(@RequestBody TicketDetails ticketDetails){
        System.out.println(ticketDetails);
        System.out.println("Your recorded inserted successfully...✅✅");

        String id = UUID.randomUUID().toString();
        SeatType seatType = new SeatType("AC_S", 102);

        TicketDetails ticket = new TicketDetails();
        ticket.setId(id);
        ticket.setFirstName("Mohacel");
        ticket.setLastName("Hosen");
        ticket.setPhoneNumber("01946363345");
        ticket.setJourneyDate(String.valueOf(LocalDate.now()));
        ticket.setTrainName("Smart-707");
        ticket.setFrom("Dhaka");
        ticket.setTo("Netrokuna");
        ticket.setSeatType(seatType);

        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

}
