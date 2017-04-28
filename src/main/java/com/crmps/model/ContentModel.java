package com.crmps.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crmps.dao.EntityContentDao;
import com.crmps.domain.Content;
import com.crmps.utils.Constant;

@Component
public class ContentModel  {

	@Autowired
	private EntityContentDao entityContentDao;

	
	public boolean addContent( String entityUid, List<Content> contents) {
		boolean retVal = false;
		if (contents != null) {
			int value = 0;
			for (Content content : contents) {
				value = entityContentDao.addContent(entityUid,content);
				if (value > 0) {
					retVal = true;
				}
			}
		}
		return retVal;
	}

	
	public boolean addContents( String entityUid, Map<String,List<Content>> contentMap) {
		boolean retVal = false;
		if (contentMap != null) {
			for (Map.Entry<String, List<Content>> entry : contentMap.entrySet()) {
				retVal = addContent( entityUid, entry.getValue());
			}
		}
		return retVal;
	}

	
	
	public List<Content> findContentByEntity(String entityUid, String type) {
		return  entityContentDao.findContentByType(entityUid, type);
	}
	
	
	public List<Content> findContentByEntity(String entityUid) {
		return  entityContentDao.findContentByType(entityUid);
	}

	public Map<String,List<Content> > findContentsByEntity(String entityUid) {
		Map<String,List<Content>> map = new HashMap<String,List<Content>>();
		List<String> contentKeys =Constant.getContentList();
		for(String key: contentKeys){
			List<Content> content =entityContentDao.findContentByType(entityUid, key);
			map.put(key, content);
		}
		return  map;
	}

}
