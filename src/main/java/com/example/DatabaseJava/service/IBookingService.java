package com.example.DatabaseJava.service;

import com.example.DatabaseJava.model.Booking;

import java.util.List;

public interface IBookingService
{
  List<Booking> GetAllBookings();
  Booking GetBooking(int id) throws Exception;
  Booking AddBooking(Booking booking) throws Exception;
  Booking RemoveBooking(int id) throws Exception;
  Booking UpdateBooking(Booking booking) throws Exception;
}
