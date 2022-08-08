package com.example.DatabaseJava.Controller;

import com.example.DatabaseJava.model.Booking;
import com.example.DatabaseJava.model.User;
import com.example.DatabaseJava.service.IBookingService;
import com.example.DatabaseJava.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BookingController{
  @Autowired
  private IBookingService BookingService;
  private IUserService UserService;

  public BookingController(IBookingService bookingService, IUserService userService)
  {
    BookingService = bookingService;
    UserService = userService;
  }

  @GetMapping("/GetAllBookings")
  public List<Booking> GetAllBookings(){
    return BookingService.GetAllBookings();
  }

  @GetMapping("/GetBooking")
  public Booking GetBooking(@RequestParam int id) throws Exception
  {

    try {
      Booking returned = BookingService.GetBooking(id);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("Booking does not exist");
    }
  }

  @PostMapping("/AddBooking")
  public Booking AddBooking(@RequestBody Booking booking) throws Exception
  {
    try {
      User user = UserService.GetUser(booking.getUser().getIdUser());
      booking.setUser(user);
      Booking returned = BookingService.AddBooking(booking);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("Booking exist" + e.getMessage());
    }

  }
  @DeleteMapping("/RemoveBooking")
  public Booking RemoveBooking(@RequestParam int id) throws Exception
  {
    try {
      Booking returned = BookingService.RemoveBooking(id);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("Booking does not exist");
    }
  }

  @PutMapping("/UpdateBooking")
  public Booking UpdateBooking(@RequestBody Booking booking) throws Exception
  {

    try {
      Booking returned = BookingService.UpdateBooking(booking);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("Booking does not exist");
    }
  }
}
