package com.example.DatabaseJava.service;

import com.example.DatabaseJava.model.Company;

import java.util.List;

public interface ICompanyService
{
  List<Company> GetCompanies();
  Company GetCompany(int id) throws Exception;
  Company AddCompany(Company company) throws Exception;
  Company RemoveCompany(int id) throws Exception;
  Company UpdateCompany(Company company) throws Exception;
}
