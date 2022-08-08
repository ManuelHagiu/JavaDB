package com.example.DatabaseJava.service.ServiceImp;

import com.example.DatabaseJava.Repository.CompanyRepository;
import com.example.DatabaseJava.model.Company;
import com.example.DatabaseJava.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService
{

  @Autowired public CompanyRepository companyRepository;

  @Override public List<Company> GetCompanies()
  {
    return (List<Company>) companyRepository.findAll();
  }

  @Override public Company GetCompany(int id) throws Exception
  {
    try
    {
      return companyRepository.findById(id).get(0);
    }
    catch (Exception e)
    {
      throw new Exception("Company does not exist");
    }
  }

  @Override public Company AddCompany(Company company) throws Exception
  {
    List<Company> found = null;
    try
    {
      found = companyRepository.findByNameCompany(company.getNameCompany());
    }
    catch (Exception e)
    {
    }
    if (found.size() > 0)
    {
      throw new Exception("Company with this name already exists");
    }
    return companyRepository.save(company);

  }

  @Override public Company RemoveCompany(int id) throws Exception
  {
    Company deleted = GetCompany(id);
    companyRepository.deleteById(id);
    return deleted;
  }

  @Override public Company UpdateCompany(Company company) throws Exception
  {
    List<Company> found = null;
    try
    {
      found = companyRepository.findByNameCompany(company.getNameCompany());
    }
    catch (Exception e)
    {
    }
    if (found.size() > 0)
    {
      throw new Exception("Company already exist");
    }
    Company updated = GetCompany(company.getIdCompany());

    updated.setNameCompany(company.getNameCompany());

    companyRepository.save(updated);
    return GetCompany(company.getIdCompany());
  }
}
