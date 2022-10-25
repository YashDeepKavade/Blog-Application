package in.ls.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ls.bindings.Category;
import in.ls.entities.CategoryEntity;
import in.ls.exceptions.ResourceNotFoundException;
import in.ls.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Category addCategory(Category category) {

		CategoryEntity cat = mapper.map(category,CategoryEntity.class);
		CategoryEntity catSaved = catRepo.save(cat);
		Category updatedCat = mapper.map(catSaved,Category.class);
		
		return updatedCat;
	}

	@Override
	public Category updateCategory(Category category, Integer catId) {

		CategoryEntity updateCatId = catRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id", catId));		
		
		updateCatId.setCatName(category.getCatName());
		updateCatId.setCatDesc(category.getCatDesc());
		
		CategoryEntity save = catRepo.save(updateCatId);
		return mapper.map(save,Category.class);
	}

	@Override
	public void deleteCategory(Integer catId) {

		CategoryEntity category = catRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", catId));
		catRepo.delete(category);
	}

	@Override
	public Category getCat(Integer catId) {

		CategoryEntity cat = catRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", catId));
		
		return mapper.map(cat,Category.class);
	}

	@Override
	public List<Category> getCategories() {

		
		List<CategoryEntity> categories = catRepo.findAll();
		List<Category> dataList=new ArrayList<Category>();
		for(CategoryEntity entity: categories) {
			Category map = mapper.map(entity,Category.class);
			dataList.add(map);
		}
		return dataList;
	}

}
