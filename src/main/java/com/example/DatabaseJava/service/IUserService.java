package com.example.DatabaseJava.service;

import com.example.DatabaseJava.model.User;

import java.util.List;

public interface IUserService
{
  List<User> GetUsers();
  User GetUser(int id) throws Exception;
  User CheckUser(String Email,String Password) throws Exception;
  User AddUser(User company) throws Exception;
  //User ValidateUser(String Email,String Password) throws Exception;
  User RemoveUser(int id) throws Exception;
  User UpdateUser(User user) throws Exception;

}
