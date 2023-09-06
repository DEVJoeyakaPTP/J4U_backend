package com.hostmdy.jobPortal.domain.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.jobPortal.domain.Category;
import com.hostmdy.jobPortal.service.CategorySevice;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

	private final CategorySevice categoryService;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody Category category){
		Category savedCategory = categoryService.save(category);
		
		return new ResponseEntity<Category>(savedCategory,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findCategoryById(@PathVariable Long id){
		Optional<Category> categoryOpt = categoryService.findCategoryById(id);
		
		if(categoryOpt.isEmpty())
			return new ResponseEntity<String>("Category not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Category>(categoryOpt.get(),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable Long id,@RequestBody Category category){
		System.out.println("Category in controller "+ category.getName());
	     Category updatedCategory = categoryService.updateCategory(id, category);
	        if (updatedCategory != null) {
	            return ResponseEntity.ok(updatedCategory);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllCategories(){
		List<Category> categoryList = categoryService.findCategories();
		
		if(categoryList.isEmpty())
			return new ResponseEntity<String>("no category found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Category>>(categoryList,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<String> deleteProductById(@PathVariable Long categoryId) {
		
		categoryService.deleteCategoryById(categoryId);
		System.out.println(categoryId);
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
}
	

