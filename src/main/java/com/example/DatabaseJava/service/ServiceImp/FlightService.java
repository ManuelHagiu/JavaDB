package com.example.DatabaseJava.service.ServiceImp;

import com.example.DatabaseJava.Repository.FlightRepository;
import com.example.DatabaseJava.model.Flight;
import com.example.DatabaseJava.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightService implements IFlightService {


  @Autowired
  public FlightRepository flightRepository;


  @Override public List<Flight> GetAllFlights()
  {
    return (List<Flight>) flightRepository.findAll();
  }

  @Override public Flight GetFlight(int id) throws Exception
  {
    try {
      return flightRepository.findByIdFlight(id);
    } catch (Exception e) {
      throw new Exception("flight does not exist "+e.getMessage());
    }
  }

  @Override public Flight AddFlight(Flight flight) throws Exception
  {
    List<Flight> found = null;
    try {
      found  = flightRepository.findByFlightNo(flight.getFlightNo());
    } catch (Exception e) {
    }
    if(found.size()>0){
      throw  new Exception("Flight with this flight number already exists");
    }
    return flightRepository.save(flight);

  }

  @Override public Flight RemoveFlight(int id) throws Exception
  {
    Flight deleted = GetFlight(id);
    flightRepository.deleteByIdFlight(id);
    return deleted;
  }

  @Override public Flight UpdateFlight(Flight flight) throws Exception
  {
    Flight updated = GetFlight(flight.getIdFlight());

    updated.setFlightNo(flight.getFlightNo());
    updated.setDepartureAirport(flight.getDepartureAirport());
    updated.setDepartureCountry(flight.getDepartureCountry());
    updated.setDepartureContinent(flight.getDepartureContinent());
    updated.setDestinationAirport(flight.getDestinationAirport());
    updated.setDestinationCountry(flight.getDestinationCountry());
    updated.setDestinationContinent(flight.getDestinationContinent());
    updated.setDateTime(flight.getDateTime());
    updated.setLength(flight.getLength());
    updated.setTotalSeats(flight.getTotalSeats());
    updated.setTotalBookedSeats(flight.getTotalBookedSeats());
    updated.setPrice(flight.getPrice());
    updated.setPriceForLuggage(flight.getPriceForLuggage());
    updated.setStatus(flight.getStatus());


    flightRepository.save(updated);
    return GetFlight(flight.getIdFlight());
  }
}
