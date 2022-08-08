package com.example.DatabaseJava.service.ServiceImp;

import com.example.DatabaseJava.Repository.BookingRepository;
import com.example.DatabaseJava.model.Booking;
import com.example.DatabaseJava.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements IBookingService {

  @Autowired
  public BookingRepository bookingRepository;
  @Override
  public List<Booking> GetAllBookings() {
    return (List<Booking>) bookingRepository.findAll();
  }

  @Override
  public Booking GetBooking(int id) throws Exception {
    try {
      return bookingRepository.findById(id).get(0);
    } catch (Exception e) {
      throw new Exception("Booking does not exist");
    }
  }

  @Override
  public Booking AddBooking(Booking booking) throws Exception {
    return bookingRepository.save(booking);
  }

  @Override
  public Booking RemoveBooking(int id) throws Exception {
    Booking deleted = GetBooking(id);
    bookingRepository.deleteById(id);
    return deleted;
  }


  @Override
  public Booking UpdateBooking(Booking booking) throws Exception {
    List<Booking> found = null;
    try {
      found  = bookingRepository.findByFlightNo(booking.getFlightNo());
    } catch (Exception e) {
    }
    if(found.size()>0){
      throw new Exception("Booking Already exist");
    }
    Booking updated = GetBooking(booking.getIdBooking());

    updated.setFlightNo(booking.getFlightNo());
    updated.setUser(booking.getUser());
    updated.setLuggage(booking.getLuggage());
    updated.setFinalPrice(booking.getFinalPrice());
    updated.setFirstName(booking.getFirstName());
    updated.setLastName(booking.getLastName());
    updated.setPassportId(booking.getPassportId());
    updated.setStatus(booking.getStatus());




    bookingRepository.save(updated);
    return GetBooking(booking.getIdBooking());
  }
}
