package com.example.DatabaseJava.Repository;

import com.example.DatabaseJava.model.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface AirportRepository extends CrudRepository<Airport, Integer>
{
  @Transactional void deleteById(int id);
  Airport findByIdAirport(int id);
  List<Airport> findByNameAirport(String name);
}
