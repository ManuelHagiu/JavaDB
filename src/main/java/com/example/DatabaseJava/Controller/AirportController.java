package com.example.DatabaseJava.Controller;

import com.example.DatabaseJava.model.Airport;
import com.example.DatabaseJava.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirportController{
  @Autowired
  private IAirportService AirportService;

  public AirportController(IAirportService airportService)
  {
    AirportService = airportService;
  }

  @GetMapping("/GetAllAirports")
  public List<Airport> GetAllAirports(){
    return AirportService.GetAllAirports();
  }

  @GetMapping("/GetAirport")
  public Airport GetOneAirport(@RequestParam int id) throws Exception
  {

    try {
      Airport returned = AirportService.GetAirport(id);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("Airport does not exist");
    }
  }

  @PostMapping("/AddAirport")
  public Airport AddAirport(@RequestBody Airport airport) throws Exception
  {
    try {
      Airport returned = AirportService.AddAirport(airport);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("Airport exist");
    }

  }
  @DeleteMapping("/RemoveAirport")
  public Airport RemoveAirport(@RequestParam int id) throws Exception
  {
    try {
      Airport returned = AirportService.RemoveAirport(id);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("Airport does not exist");
    }
  }

  @PutMapping("/UpdateAirport")
  public Airport UpdateAirport(@RequestBody Airport airport) throws Exception
  {

    try {
      Airport returned = AirportService.UpdateAirport(airport);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("Airport does not exist");
    }
  }
}
