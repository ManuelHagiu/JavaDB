package com.example.DatabaseJava.Repository;

import com.example.DatabaseJava.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer>
{
    @Transactional(rollbackOn={SQLException.class} )
    void deleteById(int id);
  List<Booking> findById(int id);
 /* List<Booking> findByName(String name);*/
  List<Booking> findByFlightNo(int FlightNO);

}
