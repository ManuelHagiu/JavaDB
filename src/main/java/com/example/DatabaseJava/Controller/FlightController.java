package com.example.DatabaseJava.Controller;

import com.example.DatabaseJava.model.Airport;
import com.example.DatabaseJava.model.Booking;
import com.example.DatabaseJava.model.Company;
import com.example.DatabaseJava.model.Flight;
import com.example.DatabaseJava.service.IAirportService;
import com.example.DatabaseJava.service.ICompanyService;
import com.example.DatabaseJava.service.IFlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController public class FlightController
{
  private final IFlightService FlightService;
  private final IAirportService AirportService;
  private final ICompanyService CompanyService;

  public FlightController(IFlightService FlightService,
      IAirportService airportService, ICompanyService companyService)
  {
    this.FlightService = FlightService;
    this.AirportService = airportService;
    this.CompanyService = companyService;
  }

  @GetMapping("/GetAllFlights") public List<Flight> GetAllFlights()
  {
    return FlightService.GetAllFlights();
  }

  @GetMapping("/GetFlight") public Flight GetFlight(@RequestParam int id)
      throws Exception
  {

    try
    {
      Flight returned = FlightService.GetFlight(id);
      System.out.println(returned);
      return returned;
    }
    catch (Exception e)
    {
      throw new Exception("Flight does not exist " + e.getMessage());
    }
  }

  @PostMapping("/AddFlight") public Flight AddFlight(@RequestBody Flight flight)
      throws Exception
  {
    try
    {

      if (flight.getDepartureAirport().getIdAirport()
          == flight.getDestinationAirport().getIdAirport())
      {
        throw new Exception("Can't be same airport ");
      }
      Airport DepartureAirport = AirportService.GetAirport(flight.getDepartureAirport().getIdAirport());
      Airport DestinationAirport = AirportService.GetAirport(flight.getDestinationAirport().getIdAirport());
      Company Company = CompanyService.GetCompany(flight.getCompany().getIdCompany());
      flight.setDepartureAirport(DepartureAirport);
      flight.setDestinationAirport(DestinationAirport);
      flight.setCompany(Company);
      Flight returned = FlightService.AddFlight(flight);
      System.out.println(returned);
      return returned;
    }
    catch (Exception e)
    {
      throw new Exception("Flight exist " + e.getMessage());
    }

  }

  @DeleteMapping("/RemoveFlight/{id}") public Flight RemoveFlight(
      @PathVariable int id) throws Exception
  {
    try
    {
      Flight returned = FlightService.RemoveFlight(id);
      System.out.println(returned);
      return returned;
    }
    catch (Exception e)
    {
      throw new Exception(e.getMessage());
    }
  }

  @PutMapping("/UpdateFlight") public Flight UpdateFlight(
      @RequestBody Flight flight) throws Exception
  {

    try
    {
      Flight returned = FlightService.UpdateFlight(flight);
      System.out.println(returned);
      return returned;
    }
    catch (Exception e)
    {
      throw new Exception("flight does not exist " + e.getMessage());
    }
  }
}