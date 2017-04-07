package com.crmps.dao;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.crmps.domain.Contact;

@Component
public class ContactDao {
	private static final Logger LOG = LoggerFactory.getLogger(ContactDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public int addContact(Contact contact) {
		LOG.info("Inserting address");
		String sql ="INSERT INTO contact (uid,type_id,value"
				+ ",created_by,updated_by, created_timestamp,updated_timestamp) "
				+ "VALUES (?,?,?,?,?,?,?)";
		int value = jdbcTemplate.update(sql,new Object[] {
					contact.getUid()
					,contact.getType()
					,contact.getValue()
					,contact.getCreatedBy()
					,contact.getUpdatedBy()
					,contact.getCreatedTimestamp()
					,contact.getUpdatedTimestamp()

				});
		return value;
	}
	
	public List<Contact> findByUid(String entityUid) {
		LOG.info("Querying Person");
		String sql="select c.uid,c.type_id, c.value"
				+ ",c.created_by,c.updated_by, c.created_timestamp,c.updated_timestamp from Contact c,entity_contact_rel cr where cr.contact_uid = c.uid and cr.entity_uid  = ?";
		List<Contact> contactList = jdbcTemplate.query(sql
				, new Object[] { entityUid } ,
				(rs, rowNum) -> {
					Contact contact = new Contact();
					contact.setUid(rs.getString("uid") ) ;
					contact.setType(rs.getString("type_id"));
					contact.setValue(rs.getString("value"));
					contact.setCreatedBy(rs.getString("created_by"));
					contact.setUpdatedBy(rs.getString("updated_by"));
					contact.setCreatedTimestamp(rs.getTimestamp("created_timestamp"));
					contact.setUpdatedTimestamp(rs.getTimestamp("updated_timestamp"));
					return contact;
				});
		return contactList;
	}
	
}
