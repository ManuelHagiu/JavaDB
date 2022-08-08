package com.example.DatabaseJava.service.ServiceImp;

import com.example.DatabaseJava.Repository.AirportRepository;
import com.example.DatabaseJava.model.Airport;
import com.example.DatabaseJava.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService implements IAirportService
{

  @Autowired
  public AirportRepository airportRepository;
  @Override
  public List<Airport> GetAllAirports() {
    return (List<Airport>) airportRepository.findAll();
  }

  @Override
  public Airport GetAirport(int id) throws Exception {
    try {
      return airportRepository.findByIdAirport(id);
    } catch (Exception e) {
      throw new Exception("Airport does not exist");
    }
  }

  @Override
  public Airport AddAirport(Airport airport) throws Exception {
    List<Airport> found = null;
    try {
      found  = airportRepository.findByNameAirport(airport.getNameAirport());
    } catch (Exception e) {
    }
    if(found.size()>0){
      throw  new Exception("Airport with this name already exists");
    }
    return airportRepository.save(airport);

  }

  @Override
  public Airport RemoveAirport(int id) throws Exception {
    Airport deleted = GetAirport(id);
    airportRepository.deleteById(id);
    return deleted;
  }


  @Override
  public Airport UpdateAirport(Airport airport) throws Exception {
    List<Airport> found = null;
    try {
      found  = airportRepository.findByNameAirport(airport.getNameAirport());
    } catch (Exception e) {
    }
    if(found.size()>0){
      throw  new Exception("Airport already exists");
    }
    Airport updated = GetAirport(airport.getIdAirport());

    updated.setNameAirport(airport.getNameAirport());

    airportRepository.save(updated);
    return GetAirport(airport.getIdAirport());
  }
}
