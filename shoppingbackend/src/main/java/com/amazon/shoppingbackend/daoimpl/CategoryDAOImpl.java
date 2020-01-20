package com.amazon.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.amazon.shoppingbackend.dao.CategoryDAO;
import com.amazon.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	
	private static List<Category> categories = new ArrayList<Category>();
	
	
	static {
		Category  category = new Category();
		
		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is a desc for television");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		
		category = new Category();
		
		// adding second category
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is a desc for Mobile");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		
		category = new Category();
		
		// adding third category
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is a desc for Laptops");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
	}	
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) {

		for(Category category: categories) {
			if (category.getId() == id) return category;
		}
		return null;
	}

}
