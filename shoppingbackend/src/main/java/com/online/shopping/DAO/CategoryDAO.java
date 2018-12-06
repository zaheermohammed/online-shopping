package com.online.shopping.DAO;

import java.util.List;

import com.online.shopping.DTO.CategoryDTO;

public interface CategoryDAO {
	
	List<CategoryDTO> list();
	
	CategoryDTO get(int id);

}
