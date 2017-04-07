package com.crmps.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.crmps.domain.EntityAddressRelation;
import com.crmps.domain.EntityContactRelation;

@Component
public class EntityReleationDao {
	private static final Logger LOG = LoggerFactory.getLogger(EntityReleationDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public int addEntityAddress(EntityAddressRelation entityAddress) {
		LOG.info("Inserting addEntityAddress ");
		String sql =" insert into entity_address_rel (entity_uid,address_uid,entity_type "
				+ ",created_by,updated_by, created_timestamp,updated_timestamp) "
				+ " VALUES (?,?,?,?,?,?,?)";
		int value = jdbcTemplate.update(sql,new Object[] {
					entityAddress.getEntityUid()
					,entityAddress.getAddressUid()
					,entityAddress.getEntityType()
					,entityAddress.getCreatedBy()
					,entityAddress.getUpdatedBy()
					,entityAddress.getCreatedTimestamp()
					,entityAddress.getUpdatedTimestamp()
				});
		return value;
	}
	
	public int addEntityContact(EntityContactRelation entityContactRel) {
		LOG.info("Inserting addEntityAddress ");
		String sql =" insert into entity_contact_rel (entity_uid,contact_uid,entity_type "
				+ ",created_by,updated_by, created_timestamp,updated_timestamp) "
				+ " VALUES (?,?,?,?,?,?,?)";
		int value = jdbcTemplate.update(sql,new Object[] {
					entityContactRel.getEntityUid()
					,entityContactRel.getContactUid()
					,entityContactRel.getEntityType()
					,entityContactRel.getCreatedBy()
					,entityContactRel.getUpdatedBy()
					,entityContactRel.getCreatedTimestamp()
					,entityContactRel.getUpdatedTimestamp()
				});
		return value;
	}
}
