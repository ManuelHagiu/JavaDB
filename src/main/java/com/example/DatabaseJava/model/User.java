package com.example.DatabaseJava.model;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table(name = "user", schema = "main", catalog = "") public class User
{
  @GeneratedValue(strategy = GenerationType.IDENTITY) @Id @Column(name = "idUser", nullable = false) private Integer idUser;
  @Basic @Column(name = "name", nullable = false, length = -1) private String name;
  @Basic @Column(name = "surname", nullable = false, length = -1) private String surname;
  @Basic @Column(name = "sex", nullable = false) private String sex;
  @Basic @Column(name = "phone", nullable = false, length = -1) private String phone;
  @Basic @Column(name = "email", nullable = false, length = -1) private String email;
  @Basic @Column(name = "password", nullable = false, length = -1) private String password;


  public Integer getIdUser()
  {
    return idUser;
  }

  public void setIdUser(Integer idUser)
  {
    this.idUser = idUser;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getSurname()
  {
    return surname;
  }

  public void setSurname(String surname)
  {
    this.surname = surname;
  }

  public String getSex()
  {
    return sex;
  }

  public void setSex(String sex)
  {
    this.sex = sex;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }


  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User that = (User) o;
    return Objects.equals(idUser, that.idUser) && Objects.equals(name,
        that.name) && Objects.equals(surname, that.surname)
        && Objects.equals(sex, that.sex) && Objects.equals(phone, that.phone)
        && Objects.equals(email, that.email) && Objects.equals(password,
        that.password) ;
  }

  @Override public int hashCode()
  {
    return Objects.hash(idUser, name, surname, sex, phone, email, password);
  }
}
