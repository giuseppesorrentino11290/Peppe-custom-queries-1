package co.develhope.customqueries1.controllers;

import co.develhope.customqueries1.entities.Flight;
import co.develhope.customqueries1.entities.FlightStatus;
import co.develhope.customqueries1.repositories.FlightRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {


    private final FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }



    @PostMapping("/")
    public ResponseEntity<String> createFlights(){

        Random random = new Random();
        List<Flight>flightList=new ArrayList<>();
        for(int i = 0; i < 50; i++){
            Flight flight = new Flight();
            flight.setId(Long.valueOf(random.nextLong()));
            flight.setDescription(Integer.toString(random.nextInt()));
            flight.setFrom_Airoport(Integer.toString(random.nextInt()));
            flight.setToAiroport(Integer.toString(random.nextInt()));
            flight.setStatus(FlightStatus.ONTIME);
            flightList.add(flight);

        }
        flightRepository.saveAll(flightList);
        return ResponseEntity.status(HttpStatus.CREATED).body("flights created");
    }
    @GetMapping("/")
    public ResponseEntity<List<Flight>> getFlights(){
        List<Flight> flightList = flightRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(flightList);
    }


}