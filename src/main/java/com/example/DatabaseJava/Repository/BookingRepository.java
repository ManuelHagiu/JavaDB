package com.example.DatabaseJava.Repository;

import com.example.DatabaseJava.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer>
{
  @Transactional
  void deleteById(int id);
  List<Booking> findById(int id);
 /* List<Booking> findByName(String name);*/
  List<Booking> findByFlightNo(int FlightNO);

}
