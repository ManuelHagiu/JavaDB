package com.example.DatabaseJava.service;

import com.example.DatabaseJava.model.Airport;

import java.util.List;

public interface IAirportService
{
  List<Airport> GetAllAirports();
  Airport GetAirport(int id) throws Exception;
  Airport AddAirport(Airport airport) throws Exception;
  Airport RemoveAirport(int id) throws Exception;
  Airport UpdateAirport(Airport airport) throws Exception;
}
