package com.example.DatabaseJava.service.ServiceImp;

import com.example.DatabaseJava.Repository.UserRepository;
import com.example.DatabaseJava.model.User;
import com.example.DatabaseJava.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService
{

  @Autowired
  public UserRepository userRepository;
  @Override
  public List<User> GetUsers() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  public User GetUser(int id) throws Exception {
    try {
      return userRepository.findById(id).get(0);
    } catch (Exception e) {
      throw new Exception("User does not exist");
    }
  }

  @Override public User CheckUser(String Email, String Password)
      throws Exception
  {
    User user;
    try {
      List<User> users = userRepository.findByEmail(Email);
      user = users.get(0);
    } catch (Exception e) {
      throw new Exception("User does not exist");
    }
    if(user.getPassword().equals(Password)) return user;
    throw new Exception("Password incorrect");

  }

  @Override
  public User AddUser(User user) throws Exception {
    List<User> found = null;
    try {
      found  = userRepository.findByEmail(user.getEmail());
      if(found.size()>0){
        throw  new Exception("User with this email already exists");
      }
    } catch (Exception e) {
    }
    return userRepository.save(user);

  }

/*
  @Override public User ValidateUser(String Email, String Password)
      throws Exception
  {
    User user;
    try {
      List<User> users = userRepository.findByEmail(Email);
      user = users.get(0);
    } catch (Exception e) {
      throw  new Exception("User does not exists");
    }
    if(user.getPassword().equals(Password)) return user;
    throw  new Exception("Password Incorrect");
  }
*/

  @Override
  public User RemoveUser(int id) throws Exception {
    User deleted = GetUser(id);
    userRepository.deleteById(id);
    return deleted;
  }


  @Override
  public User UpdateUser(User user) throws Exception {
    List<User> found = null;
    try {
      found  = userRepository.findByName(user.getName());
    } catch (Exception e) {
    }
    if(found.size()>0){
      throw  new Exception("User already exists");
    }
    User updated = GetUser(user.getIdUser());

    updated.setName(user.getName());
    updated.setSurname(user.getSurname());
    updated.setSex(user.getSex());
    updated.setPhone(user.getPhone());
    updated.setEmail(user.getEmail());
    updated.setPassword(user.getPassword());



    userRepository.save(updated);
    return GetUser(user.getIdUser());
  }
}
