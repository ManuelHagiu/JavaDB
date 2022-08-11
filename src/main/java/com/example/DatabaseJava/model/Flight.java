package com.example.DatabaseJava.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity @Table(name = "flight", schema = "main", catalog = "") public class Flight
{
  @GeneratedValue(strategy = GenerationType.AUTO) @Id @Column(name = "idFlight", nullable = false) private Integer idFlight;
  @Basic @Column(name = "flightNO", nullable = false) private int flightNo;
  @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "departureAirport", referencedColumnName = "idAirport", nullable = false) private Airport departureAirport;
  @Basic @Column(name = "departureCountry", nullable = false, length = -1) private String departureCountry;
  @Basic @Column(name = "departureContinent", nullable = false, length = -1) private String departureContinent;
  @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "destinationAirport", referencedColumnName = "idAirport", nullable = false) private Airport destinationAirport;
  @Basic @Column(name = "destinationCountry", nullable = false, length = -1) private String destinationCountry;
  @Basic @Column(name = "destinationContinent", nullable = false, length = -1) private String destinationContinent;

  @Basic @Column(name = "company", nullable = false) private String company;
  @Basic @Column(name = "dateTime", nullable = false) private LocalDateTime dateTime;
  @Basic @Column(name = "length", nullable = false, precision = 0) private double length;
  @Basic @Column(name = "totalSeats", nullable = false) private int totalSeats;
  @Basic @Column(name = "totalBookedSeats", nullable = false) private int totalBookedSeats;
  @Basic @Column(name = "price", nullable = false, precision = 0) private double price;
  @Basic @Column(name = "priceForLuggage", nullable = false, precision = 0) private double priceForLuggage;
  @Basic @Column(name = "status", nullable = false, length = -1) private String status;

  public Integer getIdFlight()
  {
    return idFlight;
  }

  public void setIdFlight(Integer idFlight)
  {
    this.idFlight = idFlight;
  }

  public int getFlightNo()
  {
    return flightNo;
  }

  public void setFlightNo(int flightNo)
  {
    this.flightNo = flightNo;
  }

  public Airport getDepartureAirport()
  {
    return departureAirport;
  }

  public void setDepartureAirport(Airport departureAirport)
  {
    this.departureAirport = departureAirport;
  }

  public String getDepartureCountry()
  {
    return departureCountry;
  }

  public void setDepartureCountry(String departureCountry)
  {
    this.departureCountry = departureCountry;
  }

  public String getDepartureContinent()
  {
    return departureContinent;
  }

  public void setDepartureContinent(String departureContinent)
  {
    this.departureContinent = departureContinent;
  }

  public Airport getDestinationAirport()
  {
    return destinationAirport;
  }

  public void setDestinationAirport(Airport destinationAirport)
  {
    this.destinationAirport = destinationAirport;
  }

  public String getDestinationCountry()
  {
    return destinationCountry;
  }

  public void setDestinationCountry(String destinationCountry)
  {
    this.destinationCountry = destinationCountry;
  }

  public String getDestinationContinent()
  {
    return destinationContinent;
  }

  public void setDestinationContinent(String destinationContinent)
  {
    this.destinationContinent = destinationContinent;
  }

  public String getCompany()
  {
    return company;
  }

  public void setCompany(String company)
  {
    this.company = company;
  }

  public LocalDateTime getDateTime()
  {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime)
  {
    this.dateTime = dateTime;
  }

  public double getLength()
  {
    return length;
  }

  public void setLength(double length)
  {
    this.length = length;
  }

  public int getTotalSeats()
  {
    return totalSeats;
  }

  public void setTotalSeats(int totalSeats)
  {
    this.totalSeats = totalSeats;
  }

  public int getTotalBookedSeats()
  {
    return totalBookedSeats;
  }

  public void setTotalBookedSeats(int totalBookedSeats)
  {
    this.totalBookedSeats = totalBookedSeats;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public double getPriceForLuggage()
  {
    return priceForLuggage;
  }

  public void setPriceForLuggage(double priceForLuggage)
  {
    this.priceForLuggage = priceForLuggage;
  }

  public String getStatus()
  {
    return status;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Flight that = (Flight) o;
    return flightNo == that.flightNo && totalSeats == that.totalSeats
        && totalBookedSeats == that.totalBookedSeats && Objects.equals(idFlight,
        that.idFlight) && Objects.equals(departureAirport,
        that.departureAirport) && Objects.equals(departureCountry,
        that.departureCountry) && Objects.equals(departureContinent,
        that.departureContinent) && Objects.equals(destinationAirport,
        that.destinationAirport) && Objects.equals(destinationCountry,
        that.destinationCountry) && Objects.equals(destinationContinent,
        that.destinationContinent) && Objects.equals(company, that.company)
        && Objects.equals(dateTime, that.dateTime)
        && Objects.equals(length, that.length) && Objects.equals(price,
        that.price) && Objects.equals(priceForLuggage, that.priceForLuggage)
        && Objects.equals(status, that.status);
  }

  @Override public int hashCode()
  {
    return Objects.hash(idFlight, flightNo, departureAirport, departureCountry,
        departureContinent, destinationAirport, destinationCountry,
        destinationContinent, company, dateTime, length, totalSeats, totalBookedSeats,
        price, priceForLuggage, status);
  }
}
