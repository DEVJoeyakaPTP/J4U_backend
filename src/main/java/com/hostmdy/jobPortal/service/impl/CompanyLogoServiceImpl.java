//package com.hostmdy.jobPortal.service.impl;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.hostmdy.jobPortal.domain.Company;
//import com.hostmdy.jobPortal.repository.CompanyRepsitory;
//import com.hostmdy.jobPortal.service.CompanyLogoService;
//
//import java.io.IOException;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class CompanyLogoServiceImpl implements CompanyLogoService{
//
//	private final CompanyRepsitory companyRepsitory;
//	
//	@Override
//	@Transactional
//	public void saveCompanyLogoToDb(Long id, MultipartFile file) {
//		// TODO Auto-generated method stub
//		if (id != null) {
//			Company company = companyRepsitory.findById(id).get();
//
//			try {
//				byte[] byteObjects = new byte[file.getBytes().length];
//				
//				int i =0;
//				for(final byte logo : file.getBytes()) {
//					byteObjects[i++] = logo;
//				}
//
//				company.setLogo(byteObjects);
//				companyRepsitory.save(company);
//
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println(" #### Error Occurs!");
//			}
//
//		} else {
//			System.out.println("###### RecipeId is null");
//		}
//	}
//
//}
