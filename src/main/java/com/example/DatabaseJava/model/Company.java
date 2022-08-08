package com.example.DatabaseJava.model;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table(name = "company", schema = "main", catalog = "") public class Company
{
  @GeneratedValue(strategy = GenerationType.AUTO) @Id @Column(name = "idCompany", nullable = true) private Integer idCompany;
  @Basic @Column(name = "nameCompany", nullable = false, length = -1) private String nameCompany;
  @Basic @Column(name = "idFlight", nullable = false) private int idFlight;

  public Integer getIdCompany()
  {
    return idCompany;
  }

  public void setIdCompany(Integer idCompany)
  {
    this.idCompany = idCompany;
  }

  public String getNameCompany()
  {
    return nameCompany;
  }

  public void setNameCompany(String nameCompany)
  {
    this.nameCompany = nameCompany;
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
    Company that = (Company) o;
    return idFlight == that.idFlight && Objects.equals(idCompany,
        that.idCompany) && Objects.equals(nameCompany, that.nameCompany);
  }

  @Override public int hashCode()
  {
    return Objects.hash(idCompany, nameCompany, idFlight);
  }
}
