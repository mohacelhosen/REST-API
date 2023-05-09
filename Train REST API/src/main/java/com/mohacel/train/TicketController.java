package com.mohacel.train;

import com.mohacel.train.binding.PassengerInfo;
import com.mohacel.train.binding.TicketInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TicketController {
    PassengerInfo passenger = new PassengerInfo();
    TicketInfo ticket = new TicketInfo();

    @PostMapping(
            value = "/ticket",
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    public ResponseEntity<TicketInfo>  bookTicket(@RequestBody PassengerInfo passengerInfo){
        passenger= passengerInfo;
        System.out.println(passengerInfo);
        // logic to book ticket
        System.out.println("Passenger Data Stored Successfully...✅");

        TicketInfo ticketStatus = new TicketInfo();
        ticketStatus.setTicketId(740);
        ticketStatus.setTrainName("Smart-707");
        ticketStatus.setSeatNumber(21);
        ticket=ticketStatus;
        return  new ResponseEntity<>(ticketStatus, HttpStatus.CREATED);
    }

    @GetMapping("/ticket")
    public ResponseEntity<TicketInfo> getTicket(){
        TicketInfo myTicket = new TicketInfo();
        myTicket=ticket;
        return new ResponseEntity<>(myTicket, HttpStatus.OK);
    }

    @PutMapping("/ticket")
    public ResponseEntity<String> updateTicket(@RequestBody PassengerInfo passengerInfo){
        System.out.println(passengerInfo);
        // logic to update the ticket
        System.out.println("Passenger Data Updated Successfully...✅");

        return  new ResponseEntity<>("Updated Successfully...✅",HttpStatus.OK);
    }

    @DeleteMapping("/ticket/{ticketId}")
    public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") Integer ticketId){
        System.out.println(ticketId);
        // logic to Delete the ticket
        System.out.println("Passenger Data Deleted Successfully...❌");

        return  new ResponseEntity<>("Deleted Successfully...❌",HttpStatus.OK);
    }

}
