package com.online.shopping.DAOimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.online.shopping.DAO.CategoryDAO;
import com.online.shopping.DTO.CategoryDTO;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<CategoryDTO> categories = new ArrayList();

	static {
		CategoryDTO category = new CategoryDTO();
		category.setId(1);
		category.setName("Television");
		category.setDescription("this is the description fot television");
		categories.add(category);

		category = new CategoryDTO();
		category.setId(2);
		category.setName("Laptop");
		category.setDescription("this is the description fot laptop");
		categories.add(category);

		category = new CategoryDTO();
		category.setId(3);
		category.setName("Mobile");
		category.setDescription("this is the description fot mobile");
		categories.add(category);
	}

	public List<CategoryDTO> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	public CategoryDTO get(int id) {
		// TODO Auto-generated method stub
		for(CategoryDTO category : categories ){
			if(category.getId()==id) return category;
		}
		return null;
	}

}
