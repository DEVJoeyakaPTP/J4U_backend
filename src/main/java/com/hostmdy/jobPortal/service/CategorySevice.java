package com.hostmdy.jobPortal.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.jobPortal.domain.Category;

public interface CategorySevice {

	List<Category> findCategories();

	Optional<Category> findCategoryById(Long id);

	Category save(Category category);
	
	Category updateCategory(Long id,Category category);

	void deleteCategoryById(Long id);
}
