package com.learning.SpringRestTicketBookingApp.controller;

import com.learning.SpringRestTicketBookingApp.model.Tourist;
import com.learning.SpringRestTicketBookingApp.service.TouristMangmentImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {
   @Autowired
    private TouristMangmentImplementation tservice;

   @PostMapping("/register")
   public ResponseEntity<String> entrollTourist(Tourist tourist)
   {
       try {
           String body=  tservice.registerTourist(tourist);
           return new ResponseEntity<String>(body, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<String>("Problem in register ", HttpStatus.INTERNAL_SERVER_ERROR);
       }

   }

   @GetMapping("/details")
    public ResponseEntity<?> displayAllTouristis(){
       try {
           List<Tourist> tList=tservice.getAllTourists();
           return new ResponseEntity<List<Tourist>>(tList, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<String>("Problem in fetching", HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
   @GetMapping("/touristInfo/{id}")
   public ResponseEntity<?> displayTouristInfo(@PathVariable Integer id){
       try {
           Tourist tourist=tservice.fetchTouristById(id);
           return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }


   @PutMapping("/updateTourist")
    public ResponseEntity<String> updateTouristInfo(@RequestBody Tourist tourist){
        try {
            String body=tservice.updateTheTouristAllDetails(tourist);

            return new ResponseEntity<String>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping ("/modify/{id}/{hike}")
    public ResponseEntity<String> updateTouristBudgetInfo(@PathVariable Integer id,@PathVariable Double hike){
        try {
            String body=tservice.updateTouristById(id, hike);

            return new ResponseEntity<String>(body, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTourist(@PathVariable Integer id)
    {
        String body=tservice.deleteTouristById(id);
        return new ResponseEntity<String>(body,HttpStatus.OK);
    }

}
