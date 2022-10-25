package in.ls.service;

import java.util.List;

import in.ls.bindings.Category;

public interface CategoryService {

	//toAdd
	public Category addCategory(Category category);
	
	//toUpadate
	public Category updateCategory(Category category,Integer catId);
	
	//toDelete
	public void deleteCategory(Integer catId);
	
	//toGetSingleId
	public Category getCat(Integer catId);
	
	//toGetAllIds
	public List<Category> getCategories();
}
