package com.hostmdy.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.jobPortal.domain.Company;
import com.hostmdy.jobPortal.domain.JobPost;
import com.hostmdy.jobPortal.repository.CompanyRepsitory;
import com.hostmdy.jobPortal.service.CompanyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

	private final CompanyRepsitory companyRepsitory;
	
	@Override
	public List<Company> findCompanies() {
		// TODO Auto-generated method stub
		return (List<Company>) companyRepsitory.findAll();
	}

	@Override
	public Optional<Company> findCompanyById(Long id) {
		// TODO Auto-generated method stub
		return companyRepsitory.findById(id);
	}

	@Override
	public Company save(Company company) {
		// TODO Auto-generated method stub
		return companyRepsitory.save(company);
	}

	@Override
	public void deleteCompanyById(Long id) {
		// TODO Auto-generated method stub
		try {
			companyRepsitory.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("$$$$$cannot be deletected by entity");
		}
	
	}

	@Override
	public Company updateCompany(Company company) {
		// TODO Auto-generated method stub
		Company existingCompany = companyRepsitory.findById(company.getId()).orElse(null);
		
        if (existingCompany != null) {
            existingCompany.setName(company.getName());
            existingCompany.setDescription(company.getDescription());
            existingCompany.setPhone(company.getPhone());
            existingCompany.setEmail(company.getEmail());
            existingCompany.setAddress(company.getAddress());
            existingCompany.setJobOpening(company.getJobOpening());
            existingCompany.setLogo(company.getLogo());
            existingCompany.setLocation(company.getLocation());
//            existingCompany.setLocation(company.getLocation());
           
            return companyRepsitory.save(existingCompany);
        } else {
            return null;
        
	}
        
        }
	}

	
