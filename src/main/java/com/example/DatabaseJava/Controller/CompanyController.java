package com.example.DatabaseJava.Controller;

import com.example.DatabaseJava.model.Company;
import com.example.DatabaseJava.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CompanyController {
  @Autowired
  private ICompanyService CompanyService;

  @GetMapping("/GetAllCompanies")
  public List<Company> GetAllCompanies(){
    return CompanyService.GetCompanies();
  }

  @GetMapping("/GetCompany")
  public Company GetCompany(@RequestParam int id) throws Exception
  {

    try {
      Company returned = CompanyService.GetCompany(id);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("Booking does not exist");
    }
  }

  @PostMapping("/AddCompany")
  public Company AddCompany(@RequestBody Company company) throws Exception
  {
    try {
      Company returned = CompanyService.AddCompany(company);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("Booking exist");
    }

  }
  @DeleteMapping("/RemoveCompany")
  public Company RemoveCompany(@RequestParam int id) throws Exception
  {
    try {
      Company returned = CompanyService.RemoveCompany(id);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("Booking does not exist");
    }
  }

  @PutMapping("/UpdateCompany")
  public Company UpdateRecipe(@RequestBody Company company) throws Exception
  {

    try {
      Company returned = CompanyService.UpdateCompany(company);
      System.out.println(returned);
      return returned;
    }catch (Exception e){
      throw new Exception("Booking does not exist");
    }
  }
}
