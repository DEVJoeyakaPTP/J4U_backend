package com.hostmdy.jobPortal.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.jobPortal.domain.Company;

public interface CompanyService {

	List<Company> findCompanies();
	
	Optional<Company> findCompanyById(Long id);
	
	Company save(Company company);
	
	Company updateCompany(Company company);
	
	void deleteCompanyById(Long id);
	
}