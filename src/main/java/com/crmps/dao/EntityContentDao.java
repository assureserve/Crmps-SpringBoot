package com.crmps.dao;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.crmps.domain.Content;

@Component
public class EntityContentDao {
	private static final Logger LOG = LoggerFactory.getLogger(EntityContentDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addContent(String entityUid,Content content) {
		LOG.info("Inserting addContent ");
		String sql =" insert into enitity_content_rel (uid,entity_uid,url,type, header "
				+ ",created_by,updated_by, created_timestamp,updated_timestamp) "
				+ " VALUES (?,?,?,?,?"
				+ ",?,?,?,?)";
		int value = jdbcTemplate.update(sql,new Object[] {
					content.getUid()
					,entityUid
					,content.getUrl()
					,content.getType()
					,content.getHeader()
					,content.getCreatedBy()
					,content.getUpdatedBy()
					,content.getCreatedTimestamp()
					,content.getUpdatedTimestamp()
				});
		return value;
	}

	

	
	public List<Content> findContentByType(String entityUid , String type) {
		LOG.info("Querying findContentByType ");
		String sql="select  ec.uid , ec.entity_uid ,ec.url ,ec.type , ec.header"
				+ ",ec.created_by,ec.updated_by, ec.created_timestamp,ec.updated_timestamp "
				+ " from enitity_content_rel ec  "
				+ " where  ec.entity_uid =? and ec.type =?";
		List<Content> contentList = jdbcTemplate.query(sql
				, new Object[] { entityUid,type } ,
				(rs, rowNum) -> {
					Content content = new Content();
					content.setUid(rs.getString("uid") ) ;
					content.setUrl(rs.getString("url"));
					content.setType(rs.getString("type"));
					content.setHeader(rs.getString("header"));
					content.setCreatedBy(rs.getString("created_by"));
					content.setUpdatedBy(rs.getString("updated_by"));
					content.setCreatedTimestamp(rs.getTimestamp("created_timestamp"));
					content.setUpdatedTimestamp(rs.getTimestamp("updated_timestamp"));
					return content;
				});
		return contentList;
	}
	

	public List<Content> findContentByType(String entityUid) {
		LOG.info("Querying findContentByType ");
		String sql="select  ec.uid , ec.entity_uid ,ec.url ,ec.type , ec.header"
				+ ",ec.created_by,ec.updated_by, ec.created_timestamp,ec.updated_timestamp "
				+ " from enitity_content_rel ec  "
				+ " where  ec.entity_uid =? and ec.type =?";
		List<Content> contentList = jdbcTemplate.query(sql
				, new Object[] { entityUid } ,
				(rs, rowNum) -> {
					Content content = new Content();
					content.setUid(rs.getString("uid") ) ;
					content.setUrl(rs.getString("url"));
					content.setType(rs.getString("type"));
					content.setHeader(rs.getString("header"));
					content.setCreatedBy(rs.getString("created_by"));
					content.setUpdatedBy(rs.getString("updated_by"));
					content.setCreatedTimestamp(rs.getTimestamp("created_timestamp"));
					content.setUpdatedTimestamp(rs.getTimestamp("updated_timestamp"));
					return content;
				});
		return contentList;
	}
	
}
