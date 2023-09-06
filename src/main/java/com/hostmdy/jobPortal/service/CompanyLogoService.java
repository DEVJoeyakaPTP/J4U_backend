package com.hostmdy.jobPortal.service;

import org.springframework.web.multipart.MultipartFile;

public interface CompanyLogoService {
	 void saveCompanyLogoToDb(Long companyId, MultipartFile file);
}
