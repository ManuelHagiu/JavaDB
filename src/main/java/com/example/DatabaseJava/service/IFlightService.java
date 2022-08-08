package com.example.DatabaseJava.service;

import com.example.DatabaseJava.model.Flight;

import java.util.List;

public interface IFlightService
{
  List<Flight> GetAllFlights();
  Flight GetFlight(int id) throws Exception;
  Flight AddFlight(Flight flight) throws Exception;
  Flight RemoveFlight(int id) throws Exception;
  Flight UpdateFlight(Flight recipe) throws Exception;
}
