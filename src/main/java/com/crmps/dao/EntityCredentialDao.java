package com.crmps.dao;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.crmps.domain.Credential;

@Component
public class EntityCredentialDao {
	private static final Logger LOG = LoggerFactory.getLogger(EntityCredentialDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public int addCredential(String entityUid,Credential credential) {
		LOG.info(" addCredential ");
		String sql =" insert into entity_credential (uid,entity_uid,type, id_number  , description, issue_date , expire_date "
				+ ",created_by,updated_by, created_timestamp,updated_timestamp) "
				+ " VALUES (?,?,?,?,?,?,?"
				+ ",?,?,?,?)";
		int value = jdbcTemplate.update(sql,new Object[] {
					credential.getUid()
					,entityUid
					,credential.getType()
					,credential.getIdNumber()
					,credential.getDescription()
					,credential.getIssueDate()
					,credential.getExpireDate()
					,credential.getCreatedBy()
					,credential.getUpdatedBy()
					,credential.getCreatedTimestamp()
					,credential.getUpdatedTimestamp()
				});
		return value;
	}
	
	public List<Credential> findByEnitityUid(String entityUid) {
		LOG.info("Querying Credential");
		String sql=" select cr.uid,cr.entity_uid,cr.type,cr.id_number,cr.description,cr.issue_date,cr.expire_date "
				+ " ,cr.created_by,cr.updated_by, cr.created_timestamp,cr.updated_timestamp "
				+ " from entity_credential cr where  cr.entity_uid  = ?";
		List<Credential> credentialList = jdbcTemplate.query(sql
				, new Object[] { entityUid } ,
				(rs, rowNum) -> {
					Credential credential = new Credential();
					credential.setUid(rs.getString("uid") ) ;
					credential.setType(rs.getString("type"));
					credential.setIdNumber(rs.getString("id_number"));
					credential.setDescription(rs.getString("description"));
					credential.setIssueDate(rs.getDate("issue_date"));
					credential.setExpireDate(rs.getDate("expire_date"));
					credential.setCreatedBy(rs.getString("created_by"));
					credential.setUpdatedBy(rs.getString("updated_by"));
					credential.setCreatedTimestamp(rs.getTimestamp("created_timestamp"));
					credential.setUpdatedTimestamp(rs.getTimestamp("updated_timestamp"));
					return credential;
				});
		return credentialList;
	}

	public List<Credential> findByEnitityUidAndType(String entityUid, String type) {
		LOG.info("Querying Credential");
		String sql=" select cr.uid,cr.entity_uid,cr.type,cr.id_number,cr.description,cr.issue_date,cr.expire_date "
				+ " ,cr.created_by,cr.updated_by, cr.created_timestamp,cr.updated_timestamp "
				+ " from entity_credential cr where  cr.entity_uid  = ? and  cr.type  = ?";
		List<Credential> credentialList = jdbcTemplate.query(sql
				, new Object[] { entityUid  , type} ,
				(rs, rowNum) -> {
					Credential credential = new Credential();
					credential.setUid(rs.getString("uid") ) ;
					credential.setType(rs.getString("type"));
					credential.setIdNumber(rs.getString("id_number"));
					credential.setDescription(rs.getString("description"));
					credential.setIssueDate(rs.getDate("issue_date"));
					credential.setExpireDate(rs.getDate("expire_date"));
					credential.setCreatedBy(rs.getString("created_by"));
					credential.setUpdatedBy(rs.getString("updated_by"));
					credential.setCreatedTimestamp(rs.getTimestamp("created_timestamp"));
					credential.setUpdatedTimestamp(rs.getTimestamp("updated_timestamp"));
					return credential;
				});
		return credentialList;
	}
}
