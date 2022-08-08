package com.example.DatabaseJava.Repository;

import com.example.DatabaseJava.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{
  List<User> findById(int id);
  List<User> findByNameUser(String NameUser);
  @Transactional void deleteById(int id);
  List<User> findByEmail(String email);

}
