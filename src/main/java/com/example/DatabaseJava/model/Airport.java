package com.example.DatabaseJava.model;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table(name = "airport", schema = "main", catalog = "") public class Airport
{
  @GeneratedValue(strategy = GenerationType.SEQUENCE) @Id @Column(name = "idAirport", nullable = false) private int idAirport;
  @Basic @Column(name = "nameAirport", nullable = false, length = -1) private String nameAirport;

  public Integer getIdAirport()
  {
    return idAirport;
  }

  public void setIdAirport(Integer idAirport)
  {
    this.idAirport = idAirport;
  }

  public String getNameAirport()
  {
    return nameAirport;
  }

  public void setNameAirport(String nameAirport)
  {
    this.nameAirport = nameAirport;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Airport that = (Airport) o;
    return Objects.equals(idAirport, that.idAirport) && Objects.equals(
        nameAirport, that.nameAirport);
  }

  @Override public int hashCode()
  {
    return Objects.hash(idAirport, nameAirport);
  }
}
