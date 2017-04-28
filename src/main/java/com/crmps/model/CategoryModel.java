package com.crmps.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crmps.dao.EntityCategoryDao;
import com.crmps.domain.Category;
import com.crmps.utils.Constant;

@Component
public class CategoryModel  {

	@Autowired
	private EntityCategoryDao entityCategoryDao;

	
	public boolean addCategory(String entityUid, Category category) {
		boolean retVal = false;
		int value = 0;
		value = entityCategoryDao.addCategory(entityUid,category);
		if (value > 0) {
			retVal = true;
		}
		return retVal;
	}
	
	

	public boolean addCategories( String entityUid, List<Category> categories) {
		boolean retVal = false;
		if (categories != null) {
			int value = 0;
			for (Category category : categories) {
				value = entityCategoryDao.addCategory(entityUid,category);
				if (value > 0) {
					retVal = true;
				}
			}
		}
		return retVal;
	}

	
	public boolean addCategories( String entityUid, Map<String,List<Category>> categories) {
		boolean retVal = false;
		if (categories != null) {
			for (Map.Entry<String, List<Category>> entry : categories.entrySet()) {
				retVal = addCategories( entityUid, entry.getValue());
			}
		}
		return retVal;
	}

	
	
	
	
	public List<Category> findCategoryByEnity(String entityUid,String type) {
		return  entityCategoryDao.findCategroyByEntityAndType(entityUid,type);
	}

	public List<Category> findCategoryByEnity(String entityUid) {
		return  entityCategoryDao.findCategroyByEntityAndType(entityUid);
	}
	
	public Map<String,List<Category> > findCategoriesByEntity(String entityUid) {
		Map<String,List<Category>> map = new HashMap<String,List<Category>>();
		List<String> categoryKeys =Constant.getCategoryList();
		for(String key: categoryKeys){
			List<Category> category =entityCategoryDao.findCategroyByEntityAndType(entityUid, key);
			map.put(key, category);
		}
		return  map;
	}
}
