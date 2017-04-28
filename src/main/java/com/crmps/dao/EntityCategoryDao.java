package com.crmps.dao;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.crmps.domain.Category;

@Component
public class EntityCategoryDao {
	private static final Logger LOG = LoggerFactory.getLogger(EntityCategoryDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addCategory(String entityUid,Category category) {
		LOG.info("Inserting addSerivceProduct ");
		String sql =" insert into enitity_category_rel (uid,entity_uid,category_uid,type "
				+ ",created_by,updated_by, created_timestamp,updated_timestamp) "
				+ " VALUES (?,?,?,?"
				+ ",?,?,?,?)";
		int value = jdbcTemplate.update(sql,new Object[] {
					category.getUid()
					,entityUid
					,category.getCategoryUid()
					,category.getType()
					,category.getCreatedBy()
					,category.getUpdatedBy()
					,category.getCreatedTimestamp()
					,category.getUpdatedTimestamp()
				});
		return value;
	}

	

	
	public List<Category> findCategroyByEntityAndType(String entityUid , String type) {
		LOG.info("Querying findCategroyByEntityAndType");
		String sql="select  ec.uid , ec.entity_uid ,ct.description ,ct.type ,ec.category_uid"
				+ ",ec.created_by,ec.updated_by, ec.created_timestamp,ec.updated_timestamp "
				+ " from enitity_category_rel ec, category_type ct  "
				+ " where ec.category_uid = ct.uid and entity_uid =? and ct.type =?";
		List<Category> categoryList = jdbcTemplate.query(sql
				, new Object[] { entityUid,type } ,
				(rs, rowNum) -> {
					Category categroy = new Category();
					categroy.setUid(rs.getString("uid") ) ;
					categroy.setDescription(rs.getString("description"));
					categroy.setType(rs.getString("type"));
					categroy.setCategoryUid(rs.getString("category_uid"));
					categroy.setCreatedBy(rs.getString("created_by"));
					categroy.setUpdatedBy(rs.getString("updated_by"));
					categroy.setCreatedTimestamp(rs.getTimestamp("created_timestamp"));
					categroy.setUpdatedTimestamp(rs.getTimestamp("updated_timestamp"));
					return categroy;
				});
		return categoryList;
	}

	public List<Category> findCategroyByEntityAndType(String entityUid ) {
		LOG.info("Querying findCategroyByEntityAndType");
		String sql="select  ec.uid , ec.entity_uid ,ct.description ,ct.type ,ec.category_uid"
				+ ",ec.created_by,ec.updated_by, ec.created_timestamp,ec.updated_timestamp "
				+ " from enitity_category_rel ec, category_type ct  "
				+ " where ec.category_uid = ct.uid and entity_uid =? and ct.type =?";
		List<Category> categoryList = jdbcTemplate.query(sql
				, new Object[] { entityUid } ,
				(rs, rowNum) -> {
					Category categroy = new Category();
					categroy.setUid(rs.getString("uid") ) ;
					categroy.setEntityUid(rs.getString("entity_uid"));
					categroy.setDescription(rs.getString("description"));
					categroy.setType(rs.getString("type"));
					categroy.setCategoryUid(rs.getString("category_uid"));
					categroy.setCreatedBy(rs.getString("created_by"));
					categroy.setUpdatedBy(rs.getString("updated_by"));
					categroy.setCreatedTimestamp(rs.getTimestamp("created_timestamp"));
					categroy.setUpdatedTimestamp(rs.getTimestamp("updated_timestamp"));
					return categroy;
				});
		return categoryList;
	}

}
