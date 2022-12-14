package com.example.DatabaseJava.model;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table(name = "booking", schema = "main", catalog = "") public class Booking
{
  @GeneratedValue(strategy = GenerationType.IDENTITY) @Id @Column(name = "idBooking", nullable = false) private Integer idBooking;
  @Basic @Column(name = "flightNO", nullable = false) private int flightNo;

  @ManyToOne @JoinColumn(name = "flight", nullable = false) private Flight flight;
  @ManyToOne @JoinColumn(name = "user", nullable = false) private User user;
  @Basic @Column(name = "luggage", nullable = false) private int luggage;
  @Basic @Column(name = "finalPrice", nullable = false, precision = 0) private double finalPrice;
  @Basic @Column(name = "firstName", nullable = false, length = -1) private String firstName;
  @Basic @Column(name = "lastName", nullable = false, length = -1) private String lastName;
  @Basic @Column(name = "passportId", nullable = false, length = -1) private String passportId;
  @Basic @Column(name = "status", nullable = false) private String status;
  @Basic @Column(name = "idFlight", nullable = false) private int idFlight;

  public Integer getIdBooking()
  {
    return idBooking;
  }

  public void setIdBooking(Integer idBooking)
  {
    this.idBooking = idBooking;
  }

  public int getFlightNo()
  {
    return flightNo;
  }

  public void setFlightNo(int flightNo)
  {
    this.flightNo = flightNo;
  }

  public Flight getFlight()
  {
    return flight;
  }

  public void setFlight(Flight flight)
  {
    this.flight = flight;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  public int getLuggage()
  {
    return luggage;
  }

  public void setLuggage(int luggage)
  {
    this.luggage = luggage;
  }

  public double getFinalPrice()
  {
    return finalPrice;
  }

  public void setFinalPrice(double finalPrice)
  {
    this.finalPrice = finalPrice;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getPassportId()
  {
    return passportId;
  }

  public void setPassportId(String passportId)
  {
    this.passportId = passportId;
  }

  public String getStatus()
  {
    return status;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public int getIdFlight()
  {
    return idFlight;
  }

  public void setIdFlight(int idFlight)
  {
    this.idFlight = idFlight;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Booking that = (Booking) o;
    return flightNo == that.flightNo && luggage == that.luggage
        && status == that.status && idFlight == that.idFlight && Objects.equals(
        idBooking, that.idBooking) && Objects.equals(user, that.user)
        && Objects.equals(flight, that.flight)
        && Objects.equals(finalPrice, that.finalPrice) && Objects.equals(
        firstName, that.firstName) && Objects.equals(lastName, that.lastName)
        && Objects.equals(passportId, that.passportId);
  }

  @Override public int hashCode()
  {
    return Objects.hash(idBooking, flightNo,flight, user, luggage, finalPrice,
        firstName, lastName, passportId, status, idFlight);
  }
}
