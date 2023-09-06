package com.hostmdy.jobPortal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.jobPortal.domain.Category;
import com.hostmdy.jobPortal.domain.Location;
import com.hostmdy.jobPortal.repository.CategoryRepository;
import com.hostmdy.jobPortal.service.CategorySevice;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategorySevice {

	private final CategoryRepository categoryRepository;

	@Override
	public List<Category> findCategories() {
		// TODO Auto-generated method stub
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findCategoryById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}

	@Override
	public Category save(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategoryById(Long id) {
		// TODO Auto-generated method stub

		Optional<Category> categoryOpt = categoryRepository.findById(id);
		
		if(categoryOpt.isPresent()) {
			Category category = categoryOpt.get();
			category.setJobPosts(null);
			
			Category updatedCategory =categoryRepository.save(category);
			
			categoryRepository.deleteById(updatedCategory.getId());
		}else 
			System.out.println("$$$$$cannot be deletected by entity");


	}

	@Override
	public Category updateCategory(Long id, Category category) {
		// TODO Auto-generated method stub
		Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);
		System.out.println("True or false" + existingCategory != null);
		if (existingCategory != null) {
			// Perform any necessary validation or business logic
			// Update the existing user entity
			existingCategory.setName(category.getName());

			return categoryRepository.save(existingCategory);
		} else {
			
			return null;
		}
	}

}
