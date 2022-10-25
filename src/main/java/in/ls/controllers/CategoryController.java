package in.ls.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ls.bindings.ApiResponse;
import in.ls.bindings.Category;
import in.ls.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@PostMapping("/addcategory")
	public ResponseEntity<Category> addCat(@Valid @RequestBody Category category){
		Category addCategory = service.addCategory(category);
		return new ResponseEntity<Category>(addCategory,HttpStatus.CREATED);
	}
	
	@PutMapping("/updatecategory/{catId}")
	public ResponseEntity<Category> updateCat(@Valid @RequestBody Category category, @PathVariable Integer catId){
		Category updateCategory = service.updateCategory(category, catId);
		return new ResponseEntity<Category>(updateCategory,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletecategory/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
		service.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted",true),HttpStatus.OK);
	}
	
	@GetMapping("/getcategory/{catId}")
	public ResponseEntity<Category> getCategory(@PathVariable Integer catId) {
		Category cat = service.getCat(catId);
		return new ResponseEntity<Category>(cat,HttpStatus.OK);
	}
	
	@GetMapping("/getcategories")
	public ResponseEntity<List<Category>> getCategories(){
		List<Category> categories = service.getCategories();
		return new ResponseEntity<List<Category>>(categories,HttpStatus.OK);
	}
	
}
