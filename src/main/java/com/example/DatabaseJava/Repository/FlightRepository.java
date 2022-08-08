package com.example.DatabaseJava.Repository;
import org.springframework.data.repository.CrudRepository;
import com.example.DatabaseJava.model.Flight;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface FlightRepository extends CrudRepository<Flight,Integer>
{
  @Transactional void deleteByIdFlight(int id);
  Flight findByIdFlight(int id);
  List<Flight> findByFlightNo(int FlightNO);

}
