package com.example.DatabaseJava.Repository;

import com.example.DatabaseJava.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer>
{
  @Transactional
  void deleteById(int id);
  List<Company> findById(int id);
  List<Company> findByNameCompany(String name);


}
