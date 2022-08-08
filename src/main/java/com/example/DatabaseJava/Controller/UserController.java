package com.example.DatabaseJava.Controller;
import com.example.DatabaseJava.model.User;
import com.example.DatabaseJava.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController
{
  @Autowired private IUserService UserService;

  @GetMapping("/GetAllUsers") public List<User> GetAllUsers()
  {
    return UserService.GetUsers();
  }

  @GetMapping("/GetUser") public User GetUser(@RequestParam int id)
      throws Exception
  {

    try
    {
      User returned = UserService.GetUser(id);
      System.out.println(returned);
      return returned;
    }
    catch (Exception e)
    {
      throw new Exception("User does not exist");
    }
  }

  @PostMapping("/AddUser") public User AddUser(@RequestBody User user)
      throws Exception
  {
    try
    {
      User returned = UserService.AddUser(user);
      System.out.println(returned);
      return returned;
    }
    catch (Exception e)
    {
      throw new Exception("User exist");
    }

  }


  @DeleteMapping("/RemoveUser")
  public User RemoveUser(@RequestParam int id) throws Exception
  {
    try {
      User returned = UserService.RemoveUser(id);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("User does not exist");
    }
  }

  @PutMapping("/UpdateUser")
  public User UpdateUser(@RequestBody User user) throws Exception
  {

    try {
      User returned = UserService.UpdateUser(user);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("User does not exist");
    }
  }
}
